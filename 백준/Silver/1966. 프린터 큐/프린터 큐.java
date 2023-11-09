import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());   // 테스트 케이스 개수
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 문서의 개수
            int M = Integer.parseInt(st.nextToken());   // 몇 번째에 놓여 있는지(0부터 시작)

            ArrayList<Integer> resList = new ArrayList<>();
            ArrayList<Integer> docList = new ArrayList<>();
            Queue<Integer> impQueue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                docList.add(j);
                impQueue.add(Integer.parseInt(st.nextToken()));
            }

            for (int j = 0; j < N; j++) {
                while (!Collections.max(impQueue).equals(impQueue.peek())) {
                    impQueue.add(impQueue.poll());
                    docList.add(docList.get(0));
                    docList.remove(0);
                }

                resList.add(docList.get(0));
                impQueue.poll();
                docList.remove(0);
            }

            System.out.println(resList.indexOf(M) + 1);
        }
    }
}
/**
1 2 3 4
2 3 4 1
3 4 1 2
4 1 2 3

4 2 3 1
4 3 1 2
4 3 2 1
*/