import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<String> stack = new Stack<>();

        int N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }

            sb.append("Case #");
            sb.append(i + 1);
            sb.append(": ");

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
                if (!stack.isEmpty()) sb.append(" ");
            }

            System.out.println(sb);
        }
    }
}