import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static int MAX = 50 + 10;
    static char[][] map;
    static boolean[][] visited;

    public static void dfs(int y, int x) {
        visited[y][x] = true;

        if (map[y][x] == '-' &&  map[y][x + 1] == '-') dfs(y, x + 1);
        if (map[y][x] == '|' && map[y + 1][x] == '|') dfs(y + 1, x);
    }

    public static void main(String[] args) throws IOException {
        // 0. 입력 및 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 세로 크기
        int M = Integer.parseInt(st.nextToken());   // 가로 크기

        map = new char[MAX][MAX];
        visited = new boolean[MAX][MAX];

        // 1. map 정보 반영
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = str.charAt(j - 1);
            }
        }

        // 2. dfs 수행
        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                    result++;
                }
            }
        }

        // 3. 출력
        System.out.println(result);
    }
}