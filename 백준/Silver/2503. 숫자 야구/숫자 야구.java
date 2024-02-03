import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 질문의 개수
        ArrayList<Integer>[] question = new ArrayList[N];
        int okCnt = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            question[i] = new ArrayList<>();
            question[i].add(Integer.parseInt(st.nextToken()));  // 세 자리 수
            question[i].add(Integer.parseInt(st.nextToken()));  // 스트라이크 개수
            question[i].add(Integer.parseInt(st.nextToken()));  // 볼 개수
        }

        // 1에서 9까지 서로 다른 숫자 세 개
        for (int i = 111; i <= 999; i++) {
            String str = String.valueOf(i);

            // 0이 들어가면 안됨
            if (str.contains("0")) continue;

            // 서로 같은 숫자가 들어가면 안됨
            char str1 = str.charAt(0);
            char str2 = str.charAt(1);
            char str3 = str.charAt(2);
            if (str1 == str2 || str1 == str3 || str2 == str3) continue;

            // 모든 물음에 통과됐는지 여부 체크
            boolean okFlag = true;

            // 질문을 모두 탐색
            for (int j = 0; j < N; j++) {
                int number = question[j].get(0);  // 세 자리 수
                int sCnt = question[j].get(1);  // 스트라이크 개수
                int bCnt = question[j].get(2);  // 볼 개수

                char[] charArray = str.toCharArray();
                char[] charArray2 = String.valueOf(number).toCharArray();
                int realSCnt = 0;
                int realBCnt = 0;

                // 스트라이크 체크
                for (int k = 0; k < 3; k++) {
                    if (charArray[k] != charArray2[k]) continue;
                    realSCnt++;
                }
                if (sCnt != realSCnt){
                    okFlag = false;
                    break;
                }

                // 볼 체크
                for (int k = 0; k < 3; k++) {
                    if (str.indexOf(charArray2[k]) == -1) continue;
                    realBCnt++;
                }
                if (bCnt != realBCnt - realSCnt) {
                    okFlag = false;
                    break;
                }
            }
            if (okFlag) okCnt++;
        }

        System.out.println(okCnt);
    }
}