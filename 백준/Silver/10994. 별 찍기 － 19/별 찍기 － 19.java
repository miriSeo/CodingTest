import java.util.Scanner;

public class Main {
    public static int[][] arr = new int[400][400];
    public static int len;

    public static void recursion(int start, int end){
        if (start == end) {
            arr[start][start] = 1;
            return;
        }

        for (int i = start; i <= end; i++) {
            arr[start][i] = 1;      // 가로상단
            arr[end][i] = 1;        // 가로하단
            arr[i][start] = 1;      // 세로좌측
            arr[i][end] = 1;        // 세로우측
        }

        recursion(start + 2, end - 2);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        len = 4 * (N - 1) + 1;
        recursion(1, len);

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) System.out.print(arr[i][j] == 1 ? "*" : " ");
            System.out.println();
        }
    }
}

/*
1 > 1(4*0+1)
2 > 5(4*1+1)
3 > 9(4*2+1)
4 > 13(4*3+1)
5 > 17(4*4+1)
(4*n-1)+1

(4*99)+1=397
 */
