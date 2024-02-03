import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 듣도 못한 사람
        int M = Integer.parseInt(st.nextToken());   // 보도 못한 사람
        Set<String> set = new TreeSet<>();
        ArrayList<String> result = new ArrayList<>();

        // 듣도 못한 사람의 이름
        while (N-- > 0) set.add(br.readLine());

        // 보도 못한 사람의 이름
        for (int i = 0; i < M; i++) {
            String next = br.readLine();
            if (set.contains(next)) result.add(next);
        }

        System.out.println(result.size());
        result.stream().sorted().iterator().forEachRemaining(System.out::println);
    }
}