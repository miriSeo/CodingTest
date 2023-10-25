import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;

        for (int i = 0; i < N; i++) {
            char[] cArr = sc.next().toCharArray();
            ArrayList<Character> list = new ArrayList<>();
            boolean isOk = true;

            for (int j = 0; j < cArr.length; j++) {
                if (j != 0 && cArr[j] != cArr[j - 1] && list.contains(cArr[j])) {
                    isOk = false;
                    break;
                }
                if (!list.contains(cArr[j])) list.add(cArr[j]);
            }

            if (isOk) result++;
        }

        System.out.println(result);
    }
}