import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        ArrayList<String> nList = new ArrayList<>();
        ArrayList<String> mList = new ArrayList<>();
        ArrayList<String> kList = new ArrayList<>();
        ArrayList<String> sList = new ArrayList<>();

        st = new StringTokenizer(br.readLine()); st.nextToken();   // 문자 구분자의 개수
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) nList.add(st.nextToken());   // 문자 구분자 담기
        map.put("N", nList);

        st = new StringTokenizer(br.readLine()); st.nextToken();   // 숫자 구분자의 개수
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) mList.add(st.nextToken());   // 숫자 구분자 담기
        map.put("M", mList);

        st = new StringTokenizer(br.readLine()); st.nextToken();   // 병합자 구분자의 개수
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) kList.add(st.nextToken());   // 병합자 구분자 담기
        map.put("K", kList);

        st = new StringTokenizer(br.readLine()); st.nextToken();   // 기준 문자열의 길이
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) sList.add(st.nextToken());   // 기준 문자열

        for (String s : sList) {
            for (char c : s.toCharArray()) {
                String target = String.valueOf(c);
                if (map.get("K").contains(target)) sb.append(c);
                else if (map.get("N").contains(target) || map.get("M").contains(target))
                    sb.append(!sb.toString().endsWith("\n") ? "\n" : "");   // 구분자 당첨
                else sb.append(c);
            }
            if (!sb.toString().endsWith("\n")) sb.append(("\n"));
        }
        System.out.println(sb.toString().trim());
    }
}