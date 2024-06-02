import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
    public static class Work {
        int No; // 과제 번호
        int A;  // 만점
        int T;  // 해결 시간

        public Work(int no, int a, int t) {
            No = no;
            A = a;
            T = t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Work> stack = new Stack<>();
        int score = 0;  // 최종 과제 점수

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int info = Integer.parseInt(st.nextToken());    // 과제의 정보
                if (info == 1) {
                    int infoA = Integer.parseInt(st.nextToken());   // 만점
                    int infoT = Integer.parseInt(st.nextToken());   // 해결 시간
                    stack.add(new Work(i, infoA, infoT));
                }

                if (!stack.isEmpty()) {
                    Work recentWork = stack.peek();
                    recentWork.T--;
                    if (recentWork.T == 0) {
                        score += recentWork.A;
                        stack.pop();
                    }
                }
            }
        }

        System.out.println(score);
    }
}