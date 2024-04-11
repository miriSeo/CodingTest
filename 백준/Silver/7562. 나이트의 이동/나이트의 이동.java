import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int[][] chess;
    static boolean[][] visited;
    static ArrayList<PointAndCount> queue = new ArrayList<>();
    static int[] dirY = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dirX = {1, 2, 2, 1, -1, -2, -2, -1};
    static int I;

    public static class PointAndCount {
        int x, y, count;
        public PointAndCount(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void bfs(int x, int y) {
        visited[y][x] = true;
        queue.add(new PointAndCount(x, y, 0));

        while (!queue.isEmpty()) {
            PointAndCount remove = queue.remove(0);
            int count = remove.count;

            for (int i = 0; i < 8; i++) {
                int newY = dirY[i] + remove.y;
                int newX = dirX[i] + remove.x;

                if (newY >= 0 && newX >= 0 && newY < I && newX < I
                        && !visited[newY][newX]) {
                    visited[newY][newX] = true;
                    queue.add(new PointAndCount(newX, newY, count + 1));
                    chess[newY][newX] = count + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            I = Integer.parseInt(br.readLine());

            chess = new int[I][I];
            visited = new boolean[I][I];

            String start = br.readLine();
            String end = br.readLine();

            int sx = Integer.parseInt(start.split(" ")[0]);
            int sy = Integer.parseInt(start.split(" ")[1]);
            int ex = Integer.parseInt(end.split(" ")[0]);
            int ey = Integer.parseInt(end.split(" ")[1]);

            bfs(sx, sy);

            System.out.println(chess[ey][ex]);
        }
    }
}