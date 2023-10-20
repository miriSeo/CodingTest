import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] cArr = sc.nextLine().toLowerCase().toCharArray();
        int count = 0;

        while (cArr[0] != '#') {
            for (char c : cArr) {
                switch (c) {
                    case 'a':
                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                        count++;
                }
            }
            System.out.println(count);
            cArr = sc.nextLine().toLowerCase().toCharArray();
            count = 0;
        }
    }
}