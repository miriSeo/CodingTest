import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100 + 10;
    static char[][] map;
    static boolean[][] visited;
    static int count = 0;
    static int result = 0;
    enum DIRECTION {HOR, VER;}

    public static void dfs(int y, int x, DIRECTION dir) {
        count++;
        visited[y][x] = true;

        // 가로
        if (dir.equals(DIRECTION.HOR) && map[y][x] == '.' && map[y][x + 1] == '.') {
            dfs(y, x + 1, DIRECTION.HOR);
        }

        // 세로
        if (dir.equals(DIRECTION.VER) && map[y][x] == '.' && map[y + 1][x] == '.') {
            dfs(y + 1, x, DIRECTION.VER);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];

        // map 정보 반영
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        // 가로
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, DIRECTION.HOR);

                    // 2칸 이상의 빈 칸이 존재하면 누울 수 있음
                    if (count >= 2) result++;
                    count = 0;
                }
            }
        }

        // 가로 출력
        System.out.print(result + " ");

        // 초기화
        count = 0;
        result = 0;
        visited = new boolean[MAX][MAX];

        // 세로
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, DIRECTION.VER);

                    // 2칸 이상의 빈 칸이 존재하면 누울 수 있음
                    if (count >= 2) result++;
                    count = 0;
                }
            }
        }

        // 세로 출력
        System.out.print(result);
    }
}