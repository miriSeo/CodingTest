import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static class Alphabet {
        int count;
        int length;

        public Alphabet(int count, int length) {
            this.count = count;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NM = br.readLine();
        int N = Integer.parseInt(NM.split(" ")[0]); // 영어 지문에 나오는 단어의 개수
        int M = Integer.parseInt(NM.split(" ")[1]); // 외울 단어의 길이 기준

        Map<String, Alphabet> map = new HashMap<>();

        while (N-- > 0) {
            String str = br.readLine();
            int length = str.length();

            if (length < M) continue;

            if (map.containsKey(str)) {
                map.get(str).count++;
            } else {
                map.put(str, new Alphabet(1, length));
            }
        }

        // 맵을 리스트로 변환
        /*
        HashMap의 엔트리를 Set으로 바꾸는 이유는 Map 자체에는 직접적으로 엔트리를 순회할 수 있는 메서드가 없기 때문
        entrySet() 메서드가 Map에 있는 모든 키-값 쌍을 반환하기 때문

        HashMap의 엔트리를 List로 변환하는 이유는 주로 엔트리들을 정렬하기 위함
        Set 자체는 순서를 보장하지 않기 때문에, 정렬된 순서로 엔트리를 처리하려면 List로 변환하여 정렬해야 함
         */
        List<Map.Entry<String, Alphabet>> list = new ArrayList<>(map.entrySet());

        // 빈도, 길이, 사전 순으로 정렬
        list.sort((a, b) -> {
            // 두 단어의 개수가 다르면
            if (b.getValue().count != a.getValue().count) {
                return b.getValue().count - a.getValue().count; // 빈도수
            }
            // 두 단어의 길이가 다르면
            else if (b.getValue().length != a.getValue().length) {
                return b.getValue().length - a.getValue().length;   // 길이
            }
            // 사전 순
            else {
                return a.getKey().compareTo(b.getKey());    // // 사전 순
            }
        });

        // 정렬된 단어 출력
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Alphabet> entry : list) {
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}