import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        int[] arr = {0, 1};
        int[] answer = {0, 0};

        for (int i = 0; i < arr.length; i++) {
            int before = (arr[i]);
            for (int j = 0; j < S.length(); j++) {
                int target = Integer.parseInt(String.valueOf(S.charAt(j)));
                if (before != target && before == (arr[i])) answer[i]++;
                before = target;
            }
        }

        System.out.println(Arrays.stream(answer).min().getAsInt());
    }
}