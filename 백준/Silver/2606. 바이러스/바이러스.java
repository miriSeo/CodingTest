import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int MAX = 100 + 10;
    static ArrayList<Integer>[] arr = new ArrayList[MAX];
    static Queue<Integer> queue = new LinkedList<>();
    static boolean[] visited = new boolean[MAX];
    static int result = -1;

    static void dfs(int target) {
        if (!visited[target]) {
            for (int i = 0; i < arr[target].size(); i++) {
                int next = arr[target].get(i);
                if (!visited[next])
                    queue.add(next);
            }

            // visited 체크
            visited[target] = true;
            // 웜 바이러스 증가
            result++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int com = sc.nextInt();
        int conn = sc.nextInt();

        for (int i = 1; i <= com; i++) {
            arr[i] = new ArrayList<>();
        }
        while (conn-- > 0) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            arr[first].add(second);
            arr[second].add(first);
        }

        // 1번 컴퓨터 웜 바이러스
        queue.add(1);

        while (!queue.isEmpty()) {
            // dfs 실행
            dfs(queue.remove());
        }

        System.out.println(result);
    }
}
