import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            if (i == 1) dp[i] = 1;
            else if (i == 2) dp[i] = 2;
            else dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}

/*
2*n 사이즈의 직사각형으로 채우려면
2*(n-1) 직사각형을 채우는 경우와 2*(n-2) 직사각형을 채우는 방법을 더함
 */