import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> pQueue = new PriorityQueue<>((c1, c2) -> {
            if (Math.abs(c1) == Math.abs(c2)) {
                return c1 > c2 ? 1 : -1;
            } else {
                return Math.abs(c1) > Math.abs(c2) ? 1 : -1;
            }
        });

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();

            if (x != 0) {
                pQueue.add(x);
            } else {
                System.out.println(pQueue.isEmpty() ? 0 : pQueue.poll());
            }
        }
    }
}