import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 연병장의 크기
        int M = Integer.parseInt(st.nextToken());   // 조교의 수
        int[] initArr = new int[N + 10];
        int[] sumArr = new int[N + 10];

        // 연병장 초기 세팅
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            initArr[i] = Integer.parseInt(st.nextToken());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int abs = Math.abs(k);

            if (k >= 0) {   // a번 칸부터 b번 칸까지 높이가 각각 |k| 만큼 늘어나도록 흙을 덮어야 한다.
                // 처음과 끝만 기록
                sumArr[a] += abs;
                sumArr[b + 1] -= abs;
            } else {    // a번 칸부터 b번 칸까지 높이가 각각 |k| 만큼 줄어들도록 흙을 파내야 한다.
                // 처음과 끝만 기록
                sumArr[a] -= abs;
                sumArr[b + 1] += abs;
            }
        }

        for (int i = 1; i <= N; i++) {
            sumArr[i] += sumArr[i - 1];
        }

        // 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(initArr[i] + sumArr[i] + " ");
        }
    }
}