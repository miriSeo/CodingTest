import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            char[] cArr = sc.next().toCharArray();
            boolean isFail = false;

            for (char c : cArr) {
                if (c == '(') {
                    stack.push(c);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    isFail = true;
                    break;
                }
            }

            if (!isFail && stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}