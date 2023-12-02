import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        for (int i = -999; i <= 999; i++) { // x
            for (int j = -999; j <= 999; j++) { // y
                if (a * i + b * j != c) continue;
                if (d * i + e * j != f) continue;
                System.out.println(i + " " + j);
                break;
            }
        }
    }
}