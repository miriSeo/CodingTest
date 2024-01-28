import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기값
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int bx = H + X;
        int by = W + Y;
        int[][] A = new int[H][W];
        int[][] moveA = new int[H][W];
        int[][] B = new int[bx][by];
        for (int i = 0; i < bx; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < by; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // 겹치지 않는 윗 부분
                if (i < X)
                    A[i][j] = B[i][j];
                    // 겹치지 않는 왼쪽 부분
                else if (j < Y)
                    A[i][j] = B[i][j];
                    // 겹치는 부분
                else
                    A[i][j] = B[i][j] - A[i - X][j - Y];

                // 출력 값 넣기
                sb.append(A[i][j]).append(" ");
            }
            // 한 줄 추가
            sb.append("\n");
        }

        // 출력
        System.out.println(sb);
    }
}
