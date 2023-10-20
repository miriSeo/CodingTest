import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cArr = sc.next().toCharArray();

        for (int i = 0; i < cArr.length; i++) {
            System.out.print(cArr[i]);
            if (i > 0 && (i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}