import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<String> S = new ArrayList<>();
        String[] T = new String[M];
        int result = 0;

        for (int i = 0; i < N; i++) {
            S.add(sc.next());
        }
        for (int i = 0; i < M; i++) {
            T[i] = sc.next();
        }

        for (int i = 0; i < T.length; i++) {
            if (S.contains(T[i])) {
                result++;
            }
        }

        System.out.println(result);
    }
}