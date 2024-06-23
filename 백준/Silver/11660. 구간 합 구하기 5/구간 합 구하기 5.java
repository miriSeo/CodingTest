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

        int[][] sumArr = new int[N + 1][N + 1];  // 합 2차원 배열

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                sumArr[i][j] = sumArr[i][j - 1] + sumArr[i - 1][j] - sumArr[i - 1][j - 1] + num;  // (i열, j-1행의 누적합) + (i-1열, j행의 누적합) - (i-1열, j-1행의 누적합) + i열, j행의 값
            }
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int firSum = sumArr[x1 - 1][y2];
            int secSum = sumArr[x2][y1 - 1];
            int twiceSum = sumArr[x1 - 1][y1 - 1];

            System.out.println(sumArr[x2][y2] - firSum - secSum + twiceSum);
        }
    }
}

/*
https://chanhuiseok.github.io/posts/baek-19/
 */