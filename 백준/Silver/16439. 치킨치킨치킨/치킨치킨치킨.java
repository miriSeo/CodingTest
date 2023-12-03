import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<int[]> list = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 회원 수
        int M = Integer.parseInt(st.nextToken());   // 치킨 종류

        while (N-- > 0) {
            int[] arr = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) arr[i] = Integer.parseInt(st.nextToken());
            list.add(arr);
        }

        for (int i = 0; i < M; i++) {   // 치킨1
            for (int j = i + 1; j < M; j++) {   // 치킨2
                for (int k = j + 1; k < M; k++) {   // 치킨3
                    int sum = 0;
                    for (int l = 0; l < list.size(); l++) {
                        int[] arr = list.get(l);
                        sum += Math.max(arr[i], Math.max(arr[j], arr[k]));
                    }
                    set.add(sum);
                }
            }
        }

        System.out.println(set.first());
    }
}