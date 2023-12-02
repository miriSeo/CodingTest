import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[Integer.parseInt(st.nextToken())];
        TreeSet<Integer> result = new TreeSet<>(Collections.reverseOrder());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < arr.length; i++) {  // 카드1
            for (int j = i + 1; j < arr.length; j++) {  // 카드2
                for (int k = j + 1; k < arr.length; k++) {  // 카드3
                    int sum = Integer.sum(arr[i], Integer.sum(arr[j], arr[k]));
                    if (sum <= M) result.add(sum);
                }
            }
        }

        System.out.println(result.first());
    }
}