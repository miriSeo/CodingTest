import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 250 + 10;
    static int[][] map;
    static boolean[][] visited;
    static int[] dirY = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dirX = {0, 1, 1, 1, 0, -1, -1, -1};
    static int result = 0;

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int newY = dirY[i] + y;
            int newX = dirX[i] + x;

            if (!visited[newY][newX] && map[newY][newX] == 1)
                dfs(newY, newX);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String mn = br.readLine();
        int M = Integer.parseInt(mn.split(" ")[0]);
        int N = Integer.parseInt(mn.split(" ")[1]);
        map = new int[MAX][MAX];
        visited = new boolean[MAX][MAX];

        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j<= N; j++) {
                int number = Integer.parseInt(st.nextToken());
                map[i][j] = number;
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j);
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}