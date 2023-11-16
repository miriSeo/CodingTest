import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            list.add(calcNum(i));
            result.add(i);
        }

        for (int i = 0; i < list.size(); i++) {
            int[] arr = list.get(i);
            int sum = 0;
            int sum2 = 0;
            for (int j = 0; j < 5; j++) {
                if (sum == 0 && arr[j] == 0) continue;
                sum *= 10;
                sum += arr[j];
                sum2 += arr[j];
            }

            int index = result.indexOf(sum + sum2);
            if (index > -1) result.remove(index);
        }

        for (int i = 0; i < result.size(); i++) System.out.println(result.get(i));
    }

    // 자릿수 계산
    private static int[] calcNum(int n) {
        int[] arr = new int[5];

        if (n / 10000 > 0) {
            arr[0] = n / 10000;
            n %= 10000;
        }
        if (n / 1000 > 0) {
            arr[1] = n / 1000;
            n %= 1000;
        }
        if (n / 100 > 0) {
            arr[2] = n / 100;
            n %= 100;
        }
        if (n / 10 > 0) {
            arr[3] = n / 10;
            n %= 10;
        }
        arr[4] = (n %= 10);

        return arr;
    }
}