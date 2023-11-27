import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        while (N-- > 0) {
            st = new StringTokenizer(bf.readLine());
            String fruit = st.nextToken();
            int count = map.get(fruit) == null ? 0 : map.get(fruit);
            map.put(fruit, count + Integer.parseInt(st.nextToken()));
        }

        System.out.println(map.containsValue(5) ? "YES" : "NO");
    }
}