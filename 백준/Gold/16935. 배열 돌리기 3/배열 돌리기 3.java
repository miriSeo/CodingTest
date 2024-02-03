import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] arr;
    static int[][] cloneArr;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        int R = Integer.parseInt(st.nextToken());
        numbers = new int[R];

        // 배열 세팅
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 수행해야 할 연산
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 연산 수행
        for (int i = 0; i < numbers.length; i++) {
            switch (numbers[i]) {
                case 1:
                    calc1();
                    break;
                case 2:
                    calc2();
                    break;
                case 3:
                    calc3();
                    break;
                case 4:
                    calc4();
                    break;
                case 5:
                    calc5();
                    break;
                case 6:
                    calc6();
                    break;
            }
            arr = cloneArr;
        }

        // 출력
        for (int i = 0; i < arr.length; i++) {
            int[] innerArr = arr[i];
            for (int j = 0; j < innerArr.length; j++) {
                System.out.print(innerArr[j] + " ");
            }
            System.out.println();
        }
    }

    // 상하 반전
    private static void calc1() {
        cloneArr = new int[N][M];
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 0; j < M; j++) {
                cloneArr[i][j] = arr[N - 1 - i][j];
            }
        }
    }

    // 좌우 반전
    private static void calc2() {
        cloneArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = M - 1; j >= 0; j--) {
                cloneArr[i][j] = arr[i][M - 1 - j];
            }
        }
    }

    // 오른쪽으로 90도 회전
    private static void calc3() {
        cloneArr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                cloneArr[i][j] = arr[N - 1 - j][i];
            }
        }
        int temp = N;
        N = M;
        M = temp;
    }

    // 왼쪽으로 90도 회전 N6 M8
    private static void calc4() {
        cloneArr = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                cloneArr[i][j] = arr[j][M - 1 - i];
            }
        }
        int temp = N;
        N = M;
        M = temp;
    }

    // N/2×M/2인 4개의 부분 배열로 나눈 후 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동
    private static void calc5() {
        cloneArr = new int[N][M];
        // 4번 그룹 -> 1번 그룹
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                cloneArr[i][j] = arr[i + N / 2][j];
            }
        }

        // 1번 그룹 -> 2번 그룹
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                cloneArr[i][j] = arr[i][j - M / 2];
            }
        }

        // 2번 그룹 -> 3번 그룹
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                cloneArr[i][j] = arr[i - N / 2][j];
            }
        }

        // 3번 그룹 -> 4번 그룹
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                cloneArr[i][j] = arr[i][j + M / 2];
            }
        }
    }

    // N/2×M/2인 4개의 부분 배열로 나눈 후 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동
    private static void calc6() {
        cloneArr = new int[N][M];
        // 2번 그룹 -> 1번 그룹
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                cloneArr[i][j] = arr[i][j + M / 2];
            }
        }

        // 3번 그룹 -> 2번 그룹
        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                cloneArr[i][j] = arr[i + N / 2][j];
            }
        }

        // 4번 그룹 -> 3번 그룹
        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                cloneArr[i][j] = arr[i][j - M / 2];
            }
        }

        // 1번 그룹 -> 4번 그룹
        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                cloneArr[i][j] = arr[i - N / 2][j];
            }
        }
    }
}