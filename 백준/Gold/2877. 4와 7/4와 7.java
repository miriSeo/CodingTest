import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        String nextBinary = Integer.toBinaryString(K + 1);
        String binary = nextBinary.substring(1);
        System.out.println(binary.replaceAll("0", "4").replaceAll("1", "7"));
    }
}