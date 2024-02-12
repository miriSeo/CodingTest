import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int[] visited;
    static ArrayList<StringBuilder> gear;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new ArrayList<>();

        // 톱니바퀴 입력
        for (int i = 0; i <= 4; i++) {
            if (i == 0) gear.add(i, new StringBuilder());
            else gear.add(i, new StringBuilder(br.readLine()));
        }

        // 회전 횟수 및 방법
        ArrayList<int[]> list = new ArrayList<>();
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            String[] str = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(str[0]), Integer.parseInt(str[1])});
        }

        // 회전
        for (int i = 0; i < list.size(); i++) {
            visited = new int[5];
            int[] arr = list.get(i);
            int target = arr[0];    // 톱니바퀴 번호
            int direction = arr[1];  // 방향 (1:시계 , -1:반시계)

            visited[target] = direction;
            checked(target);
            turn();
        }

        // 출력
        for (int i = 4; i >= 1; i--) {
            int number = Integer.parseInt(gear.get(i).substring(0, 1));

            if (i == 4) result += (number * 8);
            else if (i == 3) result += (number * 4);
            else if (i == 2) result += (number * 2);
            else result += (number * 1);
        }

        System.out.println(result);
    }

    public static void turn() {
        for (int i = 1; i <= 4; i++) {
            StringBuilder newSb = new StringBuilder();
            StringBuilder orgSb = gear.get(i);

            if (visited[i] == 0) continue;  // 회전하지 않으면 넘기기
            else if (visited[i] > 0) change(orgSb, newSb);  // 시계방향 회전
            else {  // 반시계방향 회전
                orgSb.reverse();
                change(orgSb, newSb);
                newSb.reverse();
            }

            gear.set(i, newSb);
        }
    }

    public static void checked(int target) {
        // 왼쪽 톱니바퀴 비교
        for (int i = target - 1; i >= 1; i--) {
            String right = gear.get(i).substring(2, 3);
            String left = gear.get(i + 1).substring(6, 7);

            if (right.equals(left)) break;  // 같으면 더이상 회전하지 않음
            else visited[i] = -visited[i + 1];  // 다르면 반대로 회전
        }

        // 오른쪽 톱니바퀴 비교
        for (int i = target + 1; i <= 4; i++) {
            String right = gear.get(i - 1).substring(2, 3);
            String left = gear.get(i).substring(6, 7);

            if (right.equals(left)) break;  // 같으면 더이상 회전하지 않음
            else visited[i] = -visited[i - 1];  // 다르면 반대로 회전
        }
    }

    private static void change(StringBuilder orgSb, StringBuilder newSb) {
        // 맨 뒤에있던 글자 앞으로 이동시키기
        String last = orgSb.substring(orgSb.length() - 1);
        newSb.append(last).append(orgSb.substring(0, orgSb.length() - 1));
    }
}