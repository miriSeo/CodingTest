import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new TreeMap<>();
        int N = sc.nextInt();
        while (N-- > 0){
            String next = sc.next();
            Integer count = map.get(next) == null ? 0 : map.get(next);
            map.put(next, ++count);
        }

        Integer max = Collections.max(map.values());
        for (String s : map.keySet()) {
            if (map.get(s) == max) {
                System.out.println(s);
                break;
            }
        }
    }
}