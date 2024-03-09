import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String np = br.readLine();
        int N = Integer.parseInt(np.split(" ")[0]);
        int P = Integer.parseInt(np.split(" ")[1]);
        Stack<Integer>[] stackList = new Stack[N + 1];
        int result = 0;

        // stackList 초기화
        for (int i = 1; i <= N; i++) stackList[i] = new Stack<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int flat = Integer.parseInt(st.nextToken());
            int peek = 0;
            int size = stackList[line].size();

            if (size > 0) { // 줄의 프렛을 여러개 누르고 있을 때
                while (!stackList[line].isEmpty()) {
                    peek = stackList[line].peek();
                    if (peek <= flat) break; // 낮거나 같은 프렛이면 반복문 빠져나옴

                    stackList[line].pop();
                    result++;
                }

                if (peek == flat) continue; // 같은 프렛이면 동작하지 않음

                stackList[line].push(flat);
                result++;
            } else {
                stackList[line].push(flat);
                result++;
            }
        }

        System.out.println(result);
    }
}