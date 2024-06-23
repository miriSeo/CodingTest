import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 수의 개수
        int M = sc.nextInt();  // 합을 구해야 하는 횟수
        int[] sumArr = new int[N];

        for (int i = 0; i < N; i++) {
            sumArr[i] = i == 0 ? sc.nextInt() : sumArr[i - 1] + sc.nextInt();
        }

        for (int k = 0; k < M; k++) {
            int i = sc.nextInt() - 1;   // 합구간
            int j = sc.nextInt() - 1;   // 합구간

            System.out.println(i == 0 ? sumArr[j] : sumArr[j] - sumArr[i - 1]);
        }
    }
}