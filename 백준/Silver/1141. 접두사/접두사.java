import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            if (!list.contains(s)) list.add(s);
        }

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);

            Optional<String> any = list.stream().filter(c -> !c.equals(s) && c.startsWith(s)).findAny();
            if (any.isPresent()) result++;
        }

        System.out.println(list.size() - result);
    }
}