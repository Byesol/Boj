import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] memo = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        memo[0][0] = 1; 
        memo[0][1] = 0;
        memo[1][0] = 0;
        memo[1][1] = 1;

        for (int i = 0; i < n; i++) {
            int t = Integer.parseInt(br.readLine());
            int[] result = fibonacci(t);
            sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }

        System.out.print(sb);
    }

    public static int[] fibonacci(int n) {
        if (memo[n][0] != 0 || memo[n][1] != 0 || n == 0) {
            return memo[n];
        }

        int[] fib1 = fibonacci(n - 1);
        int[] fib2 = fibonacci(n - 2);
        memo[n][0] = fib1[0] + fib2[0];
        memo[n][1] = fib1[1] + fib2[1];

        return memo[n];
    }
}
