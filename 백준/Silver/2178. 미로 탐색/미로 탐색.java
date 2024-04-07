import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int[][] map;
    static ArrayList<Point> queue;
    static boolean[][] visited;
    static int N, M;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};

    public static void bfs(int x, int y) {
        queue.add(new Point(x, y));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Point remove = queue.remove(0);

            for (int i = 0; i < 4; i++) {
                int newY = dirY[i] + remove.y;
                int newX = dirX[i] + remove.x;

                if (newY > 0 && newX > 0 && newY <= N && newX <= M
                        && !visited[newY][newX] && map[newY][newX] > 0) {
                    visited[newY][newX] = true;
                    queue.add(new Point(newX, newY));
                    map[newY][newX] += map[remove.y][remove.x];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nm = br.readLine();
        N = Integer.parseInt(nm.split(" ")[0]);
        M = Integer.parseInt(nm.split(" ")[1]);

        map = new int[N + 1][M + 1];
        queue = new ArrayList<>();
        visited = new boolean[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(str.split("")[j - 1]);
            }
        }

        bfs(1, 1);

        System.out.println(map[N][M]);
    }
}