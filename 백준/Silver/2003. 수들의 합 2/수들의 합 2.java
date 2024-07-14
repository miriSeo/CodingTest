import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    static int p1 = 0, p2 = 0, sum = 0, count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        N = Integer.parseInt(NM.split(" ")[0]);
        M = Integer.parseInt(NM.split(" ")[1]);
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum = arr[p1];
        while (p1 < N && p2 < N) {

            // 합이 M보다 작다면
            if (sum < M) {
                p2++;

                if (p2 == N) {
                    init();
                    continue;
                }

                sum += arr[p2];
            }
            // 합이 M과 같다면
            else if (sum == M) {
                count++;
                init();
            }
            // 합이 M보다 크다면
            else {
                init();
            }
        }

        System.out.println(count);
    }

    static void init() {
        p1++;
        p2 = p1;
        if (p1 < N) {
            sum = arr[p1];
        }
    }
}