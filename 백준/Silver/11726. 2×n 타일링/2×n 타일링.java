import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        /*
        ㅣ
        ㅣ
        ㅡㅡ       ㅣㅣ
        ㅡㅡ       ㅣㅣ

        ㅡㅡㅣ ㅣㅡㅡ ㅣㅣㅣ
        ㅡㅡㅣ ㅣㅡㅡ ㅣㅣㅣ

        ㅡㅡ,ㅡㅡ   ㅣㅡㅡㅣ  ㅡㅡㅣㅣ
        ㅡㅡ,ㅡㅡ   ㅣㅡㅡㅣ  ㅡㅡㅣㅣ

        ㅡㅡ,ㅡㅡㅣ   ㅣㅡㅡㅣ  ㅡㅡㅣㅣ
        ㅡㅡ,ㅡㅡㅣ   ㅣㅡㅡㅣ  ㅡㅡㅣㅣ
         */
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 2];
        dp[1] = 1;   
        dp[2] = 2;      

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.print(dp[n]);
        br.close();
    }
}
