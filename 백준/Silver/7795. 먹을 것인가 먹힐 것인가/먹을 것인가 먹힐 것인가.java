import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int p1, p2, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] nArr = new int[N];
            int[] mArr = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nArr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                mArr[i] = Integer.parseInt(st.nextToken());
            }

            // 배열 정렬
            Arrays.sort(nArr);
            Arrays.sort(mArr);

            p1 = 0; p2 = 0; count = 0;

            // p1을 기준으로, p1이 N보다 작을 경우에만 반복
            while (p1 < N) {
                // A가 B를 먹을 수 있음
                if (nArr[p1] > mArr[p2]) {
                    count++;
                    p2++;

                    if (p2 == M) {
                        init();
                    }
                }
                // A가 B를 먹을 수 없음
                else {
                    init();
                }
            }

            System.out.println(count);
        }
    }

    // 새로 탐색
    static void init() {
        p1++;
        p2 = 0;
    }
}
/*
1 1 3 7 8
1 3 6
 */