import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int INF = 100;
        int[][] d = new int[N + 1][N + 1];

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                d[i][j] = num == 0 ? INF : num;
            }
        }

        // k = 거쳐가는 노드
        for (int k = 1; k <= N; k++) {
            // i = 출발 노드
            for (int i = 1; i <= N; i++) {
                // j = 도착 노드
                for (int j = 1; j <= N; j++) {
                    // i에서 k를 거쳐 j로 가는 경로가 더 짧으면 숫자 변경
                    if (d[i][j] > d[i][k] + d[k][j])
                        d[i][j] = d[i][k] + d[k][j];
                }
            }
        }

        // 출력
        for (int i = 1; i <= N; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= N; j++) {
                sb.append(d[i][j] == INF ? 0 : 1).append(" ");
            }
            System.out.println(sb);
        }
    }
}