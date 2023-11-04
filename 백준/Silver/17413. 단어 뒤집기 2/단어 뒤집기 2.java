import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean isReverse = true;

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                isReverse = false;
                System.out.print(sb.reverse());
                sb = new StringBuilder();
            } else if (i > 0 && s.charAt(i - 1) == '>') {
                isReverse = true;
            } else if (s.charAt(i) == ' ') {
                System.out.print(sb.reverse() + " ");
                sb = new StringBuilder();
                continue;
            }

            if (isReverse) {
                sb.append(s.charAt(i));
            } else {
                System.out.print(s.charAt(i));
            }
        }
        System.out.print(sb.reverse());
    }
}