import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static int MAX = 250 + 10;
    static char[][] map;
    static boolean[][] visited;
    static int dirY[] = {-1, 1, 0, 0};
    static int dirX[] = {0, 0, -1, 1};
    static int answer[];
    static int o;
    static int v;

    public static void dfs(int y, int x) {

        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];

            if ((map[newY][newX] == '.' || map[newY][newX] == 'o' || map[newY][newX] == 'v') && !visited[newY][newX]) {
                if (map[newY][newX] == 'o') o++;
                if (map[newY][newX] == 'v') v++;
                dfs(newY, newX);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];
        answer = new int[2];

        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++)
                map[i][j] = str.charAt(j - 1);
        }

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                if (!visited[i][j]) {
                    o = 0;
                    v = 0;

                    dfs(i, j);

                    if (o > v) answer[0] += o;
                    else answer[1] += v;
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}