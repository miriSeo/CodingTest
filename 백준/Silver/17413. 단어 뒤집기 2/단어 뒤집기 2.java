import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        boolean isReverse = true;
        char[] array = br.readLine().toCharArray();
        char before = ' ';
        for (char c : array) {
            if (c == '<') {
                isReverse = false;
                System.out.print(sb.reverse());
                sb = new StringBuilder();
            } else if (before == '>') {
                isReverse = true;
            } else if (c == ' ') {
                System.out.print(sb.reverse().append(" "));
                sb = new StringBuilder();
                continue;
            }
            before = c;

            if (isReverse) sb.append(c);
            else System.out.print(c);
        }

        System.out.print(sb.reverse());
    }
}