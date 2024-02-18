import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    static final int MAX = 100 + 10;
    static int[] dirY = {-1, 1, 0, 0};
    static int[] dirX = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;
    static int[] result = {0, 0};   // 순서대로 적록색약X, 적록색약O 사람 수

    static void dfs(int y, int x, boolean isDefPerson) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];

            if (!visited[newY][newX] && map[newY][newX] != '\0') {
                char now = map[y][x];
                char next = map[newY][newX];

                // 적록색약인 사람
                if (!isDefPerson) {
                    if (now == 'G') now = 'R';
                    if (next == 'G') next = 'R';
                }

                if (now != next) continue;
                dfs(newY, newX, isDefPerson);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];

        // 데이터 입력
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        // 적록색약X
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 방문여부 체크하여 dfs 실행
                if (!visited[i][j]) {
                    dfs(i, j, true);
                    result[0]++;
                }
            }
        }

        // 방문배열 초기화
        visited = new boolean[MAX][MAX];

        // 적록색약X
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 방문여부 체크하여 dfs 실행
                if (!visited[i][j]) {
                    dfs(i, j, false);
                    result[1]++;
                }
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}