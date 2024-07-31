import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < strNumbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String strNumber : strNumbers) {
            sb.append(strNumber);
        }
        
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString();
    }
}