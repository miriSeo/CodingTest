import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int[][] numArr = new int[5][5];
    static int dirY[] = {0, 1, 0, -1};
    static int dirX[] = {1, 0, -1, 0};
    static HashSet<String> hs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, "");
            }
        }

        System.out.println(hs.size());
    }

    static void dfs(int y, int x, int cnt, String s) {

        if (cnt == 6) {
            hs.add(s);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];

            if (newX >= 0 && newX < 5 && newY >= 0 && newY < 5) {
                dfs(newY, newX, cnt + 1, s + numArr[newY][newX]);
            }
        }
    }
}