import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 삼각형의 크기
        int[][] arr = new int[n + 1][n + 1];
        int[][] sum = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; i >= j; j++) {
                // 삼각형 입력
                arr[i][j] = Integer.parseInt(st.nextToken());

                // 수의 합 입력
                int sum1 = sum[i - 1][j - 1] + arr[i][j];
                int sum2 = sum[i - 1][j] + arr[i][j];

                sum[i][j] = Math.max(sum1, sum2);
            }
        }

        System.out.println(Arrays.stream(sum[n]).max().getAsInt());
    }
}