import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= k; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        if (dp[k] == INF) {
            sb.append(-1);
        } else {
            sb.append(dp[k]);
        }

        System.out.print(sb);
    }
}
