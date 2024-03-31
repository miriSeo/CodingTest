import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map, temp;
    static boolean[][] visited;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};
    static int N, M, result = 0;

    static void rotation() {
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                if (map[y][x] > 0) {
                    temp[y][x] = map[y][x];

                    int zeroCnt = 0;
                    for (int i = 0; i < 4; i++) {
                        int newY = dirY[i] + y;
                        int newX = dirX[i] + x;

                        if (map[newY][newX] == 0) zeroCnt++;
                    }

                    if (zeroCnt > 0) temp[y][x] = Math.max(map[y][x] - zeroCnt, 0);
                }
            }
        }
    }

    static int block() {
        int rtn = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    dfs(i, j);
                    rtn++;
                }
            }
        }

        return rtn;
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int newY = dirY[i] + y;
            int newX = dirX[i] + x;

            if (!visited[newY][newX] && map[newY][newX] > 0) {
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String mn = br.readLine();
        N = Integer.parseInt(mn.split(" ")[0]);
        M = Integer.parseInt(mn.split(" ")[1]);
        map = new int[N][M];
        temp = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j< M; j++) {
                int number = Integer.parseInt(st.nextToken());
                map[i][j] = number;
            }
        }

        while(true) {
            visited = new boolean[N][M];
            temp = new int[N][M];

            int block = block();
            if (block >= 2) break;
            if (block == 0) {
                result = 0;
                break;
            }

            rotation();
            map = temp;
            result++;
        }

        System.out.println(result);
    }
}