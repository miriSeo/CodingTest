import java.util.Scanner;

public class Main {

    static int count1 = 0;
    static int count2 = 0;
    static int[] f;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f = new int[n + 1];
        fib(n);
        fibonacci(n);
        System.out.println(count1 + " " + count2);
    }

    static int fib(int n) {
        if (n == 1 || n == 2) {
            count1++;
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    static int fibonacci(int n) {
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
            count2++;
        }
        return f[n];
    }
}
/*
fib(5)
fib(4)+fib(3)
fib(3)+fib(2)+fib(2)+fib(1)
fib(2)+fib(1)


fib(5)
f[1]=f[2]=1
for(i=3;i<=n;i++)
f[3]=f[2]+f[1]=2
f[4]=f[3]+f[2]=3
f[5]=f[4]+f[3]=5
 */