import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(BigInteger.TWO.pow(n).subtract(BigInteger.ONE));

        if (n <= 20) {
            repeat(n, 1, 2, 3);
        }
    }

    public static void repeat(int n, int from, int temp, int to) {
        if (n == 1) {
            System.out.println(from + " " + to);
            return;
        }
        repeat(n - 1, from, to, temp);
        System.out.println(from + " " + to);
        repeat(n - 1, temp, from, to);
    }
}
