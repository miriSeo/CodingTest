import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        while (N-- > 0) list.add(Integer.parseInt(st.nextToken()));
        Collections.reverse(list);

        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i), list.size() - i);
        }

        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}