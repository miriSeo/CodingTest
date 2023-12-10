import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int sk = -1; //양수이면 상근, 음수이면 창영

        while (true) {
            if (N == 0) break;
            if (N >= 3) {
                N -= 3;
                sk *= -1;
            } else if (N >= 1) {
                N -= 1;
                sk *= -1;
            }
        }

        System.out.println(sk == 1 ? "SK" : "CY");
    }
}
/*
돌 4
상근 1
창영 3
 */