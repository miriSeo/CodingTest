import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] sumArr = new int[N + 1][M + 1]; // 합 2차원 배열

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                int num = Integer.parseInt(st.nextToken());
                sumArr[i][j] = sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1] + num;
            }
        }

        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());   //1
            int j = Integer.parseInt(st.nextToken());   //3
            int x = Integer.parseInt(st.nextToken());   //2
            int y = Integer.parseInt(st.nextToken());   //3

            int firSum = sumArr[i - 1][y];
            int secSum = sumArr[x][j - 1];
            int twiceSum = sumArr[i - 1][j - 1];

            System.out.println(sumArr[x][y] - firSum - secSum + twiceSum);
        }
    }
}