import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        char[] cArr = sc.nextLine().toCharArray();
        int result = 0;
        char bef = '\0';
        for (char c : cArr) {
            switch (c) {
                case '(':
                    stack.push(c);  // 쇠막대기 왼쪽 끝
                    break;
                case ')':
                    stack.pop();
                    if (bef == '(') result += stack.size(); // 레이저 발사
                    else result += 1;   // 쇠막대기 오른쪽 끝
                    break;
            }
            bef = c;
        }
        System.out.println(result);
    }
}