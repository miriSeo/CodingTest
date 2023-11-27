import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> set = new HashSet<>();
        int count = 0;

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while (N-- > 0) set.add(st.nextToken());
        for (String s : set)
            if (s.endsWith("Cheese")) count++;

        System.out.println(count >= 4 ? "yummy" : "sad");
    }
}