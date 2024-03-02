import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max;
    static int[][] map, copyMap;
    static ArrayList<Point> empty, wall, virus;
    static int dirY[] = {-1, 1, 0, 0};
    static int dirX[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];
        empty = new ArrayList<>();
        wall = new ArrayList<>();
        virus = new ArrayList<>();
        max = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 0) empty.add(new Point(i, j));
                else if (map[i][j] == 1) wall.add(new Point(i, j));
                else if (map[i][j] == 2) virus.add(new Point(i, j));
            }
        }

        building(0);
        System.out.println(max);
    }

    static void building(int cnt) {
        if (cnt == 3) {
            for (int i = 0; i < map.length; i++) {
                copyMap[i] = map[i].clone();
            }

            for (Point point : virus) {
                dfs(point.x, point.y);
            }

            int sum = 0;
            for (int[] ints : copyMap) {
                sum += (int) Arrays.stream(ints).filter(c -> c == 0).count();
            }
            if (max < sum) max = sum;
            return;
        }

        for (Point point : empty) {
            if (map[point.x][point.y] == 0) {
                map[point.x][point.y] = 1;

                building(cnt + 1);

                map[point.x][point.y] = 0;
            }
        }
    }

    static void dfs(int y, int x) {
        copyMap[y][x] = 2;

        for (int i = 0; i < 4; i++) {
            int newY = dirY[i] + y;
            int newX = dirX[i] + x;

            if (newY >= 0 && newX >= 0 && newY < N && newX < M
                    && copyMap[newY][newX] == 0) {
                dfs(newY, newX);
            }
        }
    }
}