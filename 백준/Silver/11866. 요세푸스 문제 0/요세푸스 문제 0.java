import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> result = new LinkedList<>();
        int num = 1;

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (num < K) {
                queue.add(poll);
                num++;
            } else {
                result.add(poll);
                num = 1;
            }
        }

        System.out.print("<");
        while (!result.isEmpty()) {
            System.out.print(result.poll());
            if (!result.isEmpty()) System.out.print(", ");
            else System.out.print(">");
        }
    }
}