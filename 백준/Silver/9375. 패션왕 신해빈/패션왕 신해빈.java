import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());   // 테스트케이스 수
        while (tc-- > 0) {
            int result = 1;
            HashMap<String, ArrayList<String>> map = new HashMap<>();
            int n = Integer.parseInt(sc.nextLine());   // 의상 수
            while (n-- > 0) {
                String[] arr = sc.nextLine().split(" ");
                ArrayList<String> list = map.containsKey(arr[1]) ? map.get(arr[1]) : new ArrayList<>();
                list.add(arr[0]);
                map.put(arr[1], list);
            }

            int[] resultArr = new int[map.size()];
            int idx = 0;
            for (String key : map.keySet()) {
                resultArr[idx] = map.get(key).size() + 1; // 착용+미착용
                idx++;
            }

            for (int i = 0; i < resultArr.length; i++) {
                result *= resultArr[i];
            }

            System.out.println(result - 1); // 전부 미착용 제외
        }
    }
}