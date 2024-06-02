import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] initial = new int[N][N];
        int[][] result = new int[N][N];

        // 그래프 초기화
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                initial[i][j] = num;
                result[i][j] = num;
            }
        }

        // k = 거쳐가는 노드
        for (int k = 0; k < N; k++) {
            // i = 출발 노드
            for (int i = 0; i < N; i++) {
                // j = 도착 노드
                for (int j = 0; j < N; j++) {
                    // i에서 k를 거쳐 j로 가는 경로가 있으면 (둘 다 1이라면) 숫자를 1로 출력
                    if (result[i][k] > 0 && result[k][j] > 0) result[i][j] = 1;
                }
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            System.out.println(sb);
        }
    }
}