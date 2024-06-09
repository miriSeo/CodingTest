import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int INF = 50;
        int max = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] d = new int[N][N];

        // 그래프 초기화
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                d[i][j] = str.charAt(j) == 'Y' ? 1 : INF;
            }
        }

        // k = 거쳐가는 노드
        for (int k = 0; k < N; k++) {
            // i = 출발 노드
            for (int i = 0; i < N; i++) {
                // j = 도착 노드
                for (int j = 0; j < N; j++) {
                    // 동일 인물이면 친구가 아님
                    if (i == j || j == k || k == i) continue;

                    // i에서 k를 거쳐 j로 가는 경로가 더 짧으면 숫자 변경
                    if (d[i][j] > d[i][k] + d[k][j]) {
                        d[i][j] = d[i][k] + d[k][j];
                    }
                }
            }
        }

        // 출력
        for (int i = 0; i < N; i++) {
            int sum = 0;    // 친구의 수
            for (int j = 0; j < N; j++) {
                // 두 사람이 친구: 1
                // 동시에 겹치는 한 친구가 존재: 2
                if (d[i][j] == 1 || d[i][j] == 2) sum++;
            }

            if (max < sum) max = sum;
        }

        System.out.println(max);
    }
}