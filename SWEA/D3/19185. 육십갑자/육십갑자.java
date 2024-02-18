import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {
            StringBuilder sb = new StringBuilder("#" + i + " ");

            String nm = br.readLine();
            int N = Integer.parseInt(nm.split(" ")[0]);
            int M = Integer.parseInt(nm.split(" ")[1]);

            String[] nArr = new String[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) nArr[j] = st.nextToken();

            String[] mArr = new String[M + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) mArr[j] = st.nextToken();

            int Q = Integer.parseInt(br.readLine());
            while (Q-- > 0) {
                int req = Integer.parseInt(br.readLine());
                int n = req % N == 0 ? N : req % N;
                int m = req % M == 0 ? M : req % M;
                sb.append(nArr[n]).append(mArr[m]).append(" ");
            }

            System.out.println(sb);
        }
    }
}