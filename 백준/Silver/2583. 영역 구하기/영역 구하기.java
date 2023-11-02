import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int dirY[] = {0, 1, 0, -1};
    static int dirX[] = {1, 0, -1, 0};
    static int M = 0;
    static int N = 0;
    static int[][] areaArr;
    static int sum = 0;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int x1, y1, x2, y2;
        areaArr = new int[M][N];
        ArrayList<Integer> list = new ArrayList<>();

        // 전부 1로 초기화
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                areaArr[i][j] = 1;
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            // 직사각형 영역 0으로 입력
            for (int j = Math.min(y1, y2); j < Math.max(y1, y2); j++) {
                for (int k = Math.min(x1, x2); k < Math.max(x1, x2); k++) {
                    areaArr[j][k] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (areaArr[i][j] == 1) {
                    sum = 0;    // 영역 넓이 초기와
                    dfs(i, j);  // 재귀함수 실행
                    list.add(sum);
                    count++;
                }
            }
        }

        System.out.println(count);

        Collections.sort(list); // 정렬
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) System.out.print(" ");
        }
    }

    private static void dfs(int y, int x) {
        sum++;  // 영역 넓이 합산
        areaArr[y][x] = 0;  // 이미 방문했으면 0으로 변경
        for (int i = 0; i < 4; i++) {
            int newY = y + dirY[i];
            int newX = x + dirX[i];

            if (newY >= 0 && newX >= 0 && newY < M && newX < N)
            if (areaArr[newY][newX] == 1) {
                dfs(newY, newX);
            }
        }
    }
}