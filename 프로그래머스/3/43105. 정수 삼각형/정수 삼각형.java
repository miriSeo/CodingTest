import java.util.Arrays;

class Solution {
    static final int MAX = 500 + 10;
    
    public int solution(int[][] triangle) {
        int[][] dp = new int[MAX][MAX];

        for (int i = 1; i <= triangle.length; i++) {
            int[] rows = triangle[i - 1];
            for (int j = 1; j <= rows.length; j++) {
                // 아래 칸
                int newNum1 = dp[i - 1][j] + triangle[i - 1][j - 1];
                // 대각선 아래 칸
                int newNum2 = dp[i - 1][j - 1] + triangle[i - 1][j - 1];
                // 둘 중 큰 값
                dp[i][j] = Math.max(newNum1, newNum2);
            }
        }

        return Arrays.stream(dp[triangle.length]).max().getAsInt();
    }
}