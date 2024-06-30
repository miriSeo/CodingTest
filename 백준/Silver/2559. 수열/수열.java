import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 온도를 측정한 전체 날짜의 수
        int K = Integer.parseInt(st.nextToken());   // 합을 구하기 위한 연속적인 날짜의 수
        int[] arr = new int[N + 1];
        int result = Integer.MIN_VALUE;

        // 초기 세팅
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken()); // 이전 누적합에 더해줌
        }

        for (int i = K; i <= N; i++) {
            result = Math.max(result, arr[i] - arr[i - K]);
        }

        System.out.println(result);
    }
}