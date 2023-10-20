import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] cArr = s.toCharArray();
        String r = "";

        while (cArr[0] != '0') {
            for (int i = cArr.length - 1; i >= 0; i--) {
                r += String.valueOf(cArr[i]);
            }
            System.out.println(String.valueOf(cArr).equals(r) ? "yes" : "no");
            
            s = sc.next();
            cArr = s.toCharArray();
            r = "";
        }
    }
}