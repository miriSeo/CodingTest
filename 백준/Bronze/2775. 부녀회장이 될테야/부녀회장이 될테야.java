import java.util.Scanner;

public class Main {

    static int[][] aptArr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   // 테스트케이스
        while (T-- > 0) {
            int k = sc.nextInt();   // 층
            int n = sc.nextInt();   // 호
            aptArr = new int[k + 1][n + 1];

            for (int i = 1; i <= n; i++) aptArr[0][i] = i;  // 0층 i호 i명 거주

            for (int i = 1; i <= k; i++)
                for (int j = 1; j <= n; j++)
                    aptArr[i][j] = getAptArr(i - 1, j);

            System.out.println(aptArr[k][n]);
        }
    }

    private static int getAptArr(int a, int b) {
        int sum = 0;
        for (int i = 1; i <= b; i++) sum += aptArr[a][i];
        return sum;
    }
}

/*
k층 n호
0층부터 / 1호부터
* 2층 3호 *
1층 1호:(1-1)층 1호~1호까지 합 1명
1층 2호:(1-1)층 1호~2호까지 합 3명
1층 3호:(1-1)층 1호~3호까지 합 6명
-> (2-1)층 1호~3호까지 합 10명
 */