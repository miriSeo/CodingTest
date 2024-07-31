import java.util.Arrays;

class Solution {
    public int solution(String dartResult) {
        char[] charArray = dartResult.toCharArray();
        int[] scores = new int[3];
        int index = -1;

        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            /** 점수 */
            if (c >= 48 && c <= 58) {
                index++;
                // 10 처리
                if (c == '1' && charArray[i + 1] == '0') {
                    scores[index] = 10;
                    i++;
                } else {
                    scores[index] = c - '0';
                }
            }
            else {
                switch (c) {
                    /** 보너스 */
                    case 'S':
                        scores[index] = (int) Math.pow(scores[index], 1);
                        break;
                    case 'D':
                        scores[index] = (int) Math.pow(scores[index], 2);
                        break;
                    case 'T':
                        scores[index] = (int) Math.pow(scores[index], 3);
                        break;

                    /** 옵션 */
                    case '*':
                        if (index > 0) scores[index - 1] *= 2;
                        scores[index] *= 2;
                        break;
                    case '#':
                        scores[index] *= -1;
                        break;
                }
            }
        }

        return Arrays.stream(scores).sum();
    }
}
