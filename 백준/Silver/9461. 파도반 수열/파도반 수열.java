import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            long[] dp = new long[N + 1];

            for (int i = 1; i <= N; i++) {
                if (i == 1) dp[i] = 1;
                else if (i == 2) dp[i] = 1;
                else if (i == 3) dp[i] = 1;
                else if (i == 4) dp[i] = 2;
                else if (i == 5) dp[i] = 2;
                else dp[i] = dp[i - 1] + dp[i - 5];
            }

            System.out.println(dp[N]);
        }
    }
}
/*
1 1 1 2 2 3 4 5 7 9 12
 */