import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        char[] cArr = S.toCharArray();
        int minLen = Integer.MAX_VALUE;

        for(int j = 0; j < cArr.length; j++) {
            String front = "";
            String back = "";
            String R = "";

            for (int i = j; i < cArr.length; i++) {
                front += String.valueOf(cArr[i]);
            }

            for (int i = cArr.length - 1; i >= j; i--) {
                back += String.valueOf(cArr[i]);
            }

            if (front.equals(back)) {
                char[] rArr = S.substring(0, j).toCharArray();

                for (int i = rArr.length - 1; i >= 0; i--) {
                    R += String.valueOf(rArr[i]);
                }

                if (minLen > (S + R).length()) {
                    minLen = (S + R).length();
                    break;
                }
            }
        }

        System.out.println(minLen);
    }
}