/**
 * 반례
 * 4
 * 5
 * 3
 * 3
 * 1
 *
 *
 * 5
 * 2
 * 2
 * 2
 * 3
 * 1
 *
 * 5
 * 9
 * 7
 * 5
 * 5
 * 3
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            stack.push(sc.nextInt());
        }

        int max = stack.pop();
        set.add(max);

        for (int i = 1; i < N; i++) {
            Integer peek = stack.peek();
            if (peek > max) {
                max = peek;
                set.add(max);
            }
            stack.pop();
        }

        System.out.println(set.size());
    }
}