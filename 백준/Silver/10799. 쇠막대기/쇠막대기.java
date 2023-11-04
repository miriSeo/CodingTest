import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cArr = sc.nextLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == '(') {
                stack.push(cArr[i]);
            } else {
                stack.pop();

                if (cArr[i - 1] == '(') {
                    result += stack.size();
                } else {
                    result += 1;
                }
            }
        }

        System.out.println(result);
    }
}