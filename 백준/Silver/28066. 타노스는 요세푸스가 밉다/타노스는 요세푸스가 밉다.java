import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(str.split(" ")[0]);
        int K = Integer.parseInt(str.split(" ")[1]);

        // 1부터 N마리의 청솔모
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            // 남아 있는 청설모가 K마리보다 적으면 첫 번째 청설모 출력
            if (queue.size() < K) {
                System.out.println(queue.poll());
                return;
            }

            int first = queue.poll();   // 1번 청솔모
            for (int i = 0; i < K - 1; i++) {
                // K마리를 지우다 모두 제거되면 첫 번째 청솔모 출력
                if (queue.isEmpty()) {
                    System.out.println(first);
                    return;
                }
                queue.poll();
            }
            queue.add(first);
        }

        System.out.println(queue.poll());
    }
}