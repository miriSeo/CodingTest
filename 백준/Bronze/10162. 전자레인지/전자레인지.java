import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int btnA = 300; int cntA = 0;
        int btnB = 60; int cntB = 0;
        int btnC = 10; int cntC = 0;

        while (T / btnA > 0) {
            T -= btnA; 
            cntA++;
        }

        while (T / btnB > 0) {
            T -= btnB;
            cntB++;
        }

        while (T / btnC > 0) {
            T -= btnC;
            cntC++;
        }

        System.out.println(T > 0 ? "-1" : cntA + " " + cntB + " " + cntC);
    }
}