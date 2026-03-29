import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // f(n) = f(n) +f(n-3))fjd

    // f(0) f(1) f(2) f(3) f(4) f(5) f(6) f(7) f(8) f(9) f(10)
    // 1    1     2    2    3    4    5    7     9  12
    //f(9) = f(8) + f(4)
    // f(8) = f(7) + f(3)
    // f(7) = f(6) + f(2)
    // f(6) = f(5) + f(1)
    static long[] memory = new long[101];

    public static void main(String[] args) throws IOException {
        memory[0] = 1;
        memory[1] = 1;
        memory[2] = 1;
        memory[3] = 2;
        memory[4] = 2;
        memory[5] = 3;
        memory[6] = 4;
        memory[7] = 5;
        memory[8] = 7;
        memory[9] = 9;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp(n - 1)).append("\n");

        }
        System.out.println(sb);

        br.close();
    }

    public static long dp(int n) {

        if (memory[n] != 0) {
            return memory[n];
        }

        long result = dp(n - 1) + dp(n - 5);
        memory[n] = result;
        return result;

    }
}
