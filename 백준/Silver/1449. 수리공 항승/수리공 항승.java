import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int before = arr[0];
        int count = 0;

        for (int i = 1; i < N; i++) {
            if (L <= arr[i] - before) {
                count++;
                before = arr[i];
            }
        }

        System.out.println(++count);
    }
}