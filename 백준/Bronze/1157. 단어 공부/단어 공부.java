import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cArr = sc.next().toUpperCase().toCharArray();
        Arrays.sort(cArr);

        Character maxChar = ' ';
        int maxCount = 0;
        int count = 0;
        Character curChar = ' ';
        Character beforeChar = cArr[0];
        boolean isSame = false;

        for (int i = 0; i < cArr.length; i++) {
            curChar = cArr[i];
            if (curChar == beforeChar) {
                count++;
            } else {
                if (count > maxCount) {
                    maxCount = count;
                    maxChar = beforeChar;
                    if(isSame) isSame = false;
                } else if (count == maxCount) {
                    isSame = true;
                }
                count = 1;
            }
            beforeChar = curChar;
        }

        if (count > maxCount) {
            System.out.println(beforeChar);
        } else if (count == maxCount) {
            System.out.println("?");
        } else {
            System.out.println(isSame ? "?" : maxChar);
        }
    }
}