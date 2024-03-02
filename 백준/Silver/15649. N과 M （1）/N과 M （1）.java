import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static boolean[] visited;
    static int[] arr;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    private static void dfs(int depth) {
        // depth가 M의 길이와 같으면 출력 담기
        if (depth == M) {
            for (int j : arr) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;

                arr[depth] = i + 1;
                dfs(depth + 1);
                
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        dfs(0);

        // 최종 출력
        System.out.println(sb);
    }
}