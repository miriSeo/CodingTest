import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            int result = 1;

            // M 구역의 사이트에서 N 구역의 사이트 갯수만큼 연결할 사이트에 대한 조합 계산
            // (N <= M) = mCn = (29*28*27...18*17) / 13! = M*(M-1)*(M-2)*(M-N+1) / N!
            for (int i = 1; i <= N; i++) {
                result *= (M - i + 1);
                result /= i;
            }

            System.out.println(result);
        }
    }
}