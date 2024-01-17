import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    final static int MAX = 100000 + 10;
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> queue;
    static boolean[] visited;
    static int[] answer;
    static int order;
    static int N, M, R;

    public static void bfs() {
        queue.add(R);
        visited[R] = true;
        answer[R] = order;

        while (!queue.isEmpty()) {
            int idx = queue.remove(0);

            for (int i = 0; i < graph[idx].size(); i++) {
                if (!visited[graph[idx].get(i)]) {
                    queue.add(graph[idx].get(i));
                    visited[graph[idx].get(i)] = true;
                    answer[graph[idx].get(i)] = ++order;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 정점의 수
        M = Integer.parseInt(st.nextToken());   // 간선의 수
        R = Integer.parseInt(st.nextToken());   // 시작 정점

        // 1. graph에 연결 정보 채우기
        graph = new ArrayList[MAX];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        queue = new ArrayList<>();
        visited = new boolean[MAX];
        answer = new int[MAX];
        order = 1;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        // 2. 내림차순 정렬
        for (int i = 1; i <= N; i++) graph[i].sort(Collections.reverseOrder());

        // 3. bfs
        bfs();

        // 4. 출력
        for (int i = 1; i <= N; i++) System.out.println(answer[i]);
    }
}
/*
[1]-4-2
[2]-1-3-4
[3]-2-4
[4]-1-2-3
[5]
 */