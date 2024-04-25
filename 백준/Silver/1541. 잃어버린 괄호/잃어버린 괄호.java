import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] minusArr = str.split("-"); // 뺄셈을 기준으로 1차적 분리
        int result = 0;
        for (int i = 0; i < minusArr.length; i++) {
            int sum = getSum(minusArr[i]);  // 분리된 문자열의 각각에 포함된 정수 값들을 더해줌

            if (i == 0) result = sum;   // 첫 번째 수에서 빼줌
            else result -= sum;  // 각각 더해진 값들을 모두 빼줌
        }

        System.out.println(result);
    }

    private static int getSum(String minusArr) {
        String[] plusArr = minusArr.split("\\+");
        int sum = 0;
        for (int j = 0; j < plusArr.length; j++) {
            sum += Integer.parseInt(plusArr[j]);
        }
        return sum;
    }
}