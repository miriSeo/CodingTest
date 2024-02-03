import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 수업의 개수
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());   // 시작강의
            arr[i][1] = Integer.parseInt(st.nextToken());   // 끝강의
        }

        // 오름차순으로 정렬
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // 첫 강의의 끝깡의 추가
        pq.add(arr[0][1]);

        for (int i = 1; i < N; i++) {
            // 시작강의가 pq에 담겨있으면 poll 후 끝강의 추가
            // 끝난 직후에만 가능한게 아니라 그 이후 수업 전부 가능
            if (arr[i][0] >= pq.peek()) pq.poll();

            // 끝강의 추가
            pq.add(arr[i][1]);
        }

        System.out.println(pq.size());
    }
}
/*
1 2 3 
    3 4 5
    
   2 3 4
------------
  0 1
        3 4
  0 3
    3 4
 */