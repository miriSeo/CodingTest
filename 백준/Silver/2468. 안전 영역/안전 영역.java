import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int N;
    static Set<Integer> result = new TreeSet<>(Comparator.reverseOrder());

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = dirY[i] + y;
            int newX = dirX[i] + x;

            if (newY >= 0 && newX >= 0 && newY < N && newX < N
                    && !visited[newY][newX] && map[newY][newX] > 0) {
                dfs(newY, newX);
            }
        }
    }

    public static int findArea() {
        int area = 0;
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    dfs(i, j);
                    area++;
                }
            }
        }

        return area;
    }
    
    public static void sink(int height) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= height) map[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 높이는 1이상 100이하
        for (int i = 0; i <= 100; i++) {
            sink(i); // 높이 이하의 지점이 물에 잠김
            result.add(findArea());// 물에 잠기지 않은 영역
        }

        System.out.println(result.iterator().next());   // 내림차순 정렬이기 때문에 next()로 최대 개수를 출력
    }
}