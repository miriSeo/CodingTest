import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int money = 1000 - sc.nextInt();
        int count = 0;

        while (money / 500 > 0) {
            money -= 500;
            count++;
        }

        while (money / 100 > 0) {
            money -= 100;
            count++;
        }

        while (money / 50 > 0) {
            money -= 50;
            count++;
        }

        while (money / 10 > 0) {
            money -= 10;
            count++;
        }

        while (money / 5 > 0) {
            money -= 5;
            count++;
        }

        while (money / 1 > 0) {
            money -= 1;
            count++;
        }

        System.out.println(count);
    }
}