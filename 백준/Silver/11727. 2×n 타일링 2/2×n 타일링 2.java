import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        /*
        ㅣ
        ㅣ   다시 말해서 얘한테 붙이는 게 두 배된거. 원래는 하나라 그냥 더하기로 했는디
        ㅡㅡ       ㅣㅣ  ㅁㅁ
        ㅡㅡ       ㅣㅣ  ㅁㅁ
        ㅡㅡㅣ ㅣㅡㅡ ㅣㅣㅣ ㅁㅁㅣ ㅣㅁㅁ
        ㅡㅡㅣ ㅣㅡㅡ ㅣㅣㅣ ㅁㅁㅣ ㅣㅁㅁ

        ㅡㅡ,ㅡㅡ   ㅣㅡㅡㅣ  ㅡㅡㅣㅣ   ㅁㅁㅁㅁ   ㅣㅁㅁㅣ  ㅁㅁㅣㅣ ㅁㅁㅡㅡ ㅡㅡㅁㅁ
        ㅡㅡ,ㅡㅡ   ㅣㅡㅡㅣ  ㅡㅡㅣㅣ   ㅁㅁㅁㅁ   ㅣㅁㅁㅣ  ㅁㅁㅣㅣ ㅁㅁㅡㅡ ㅡㅡㅁㅁ

        ㅡㅡ,ㅡㅡㅣ   ㅣㅡㅡㅣ  ㅡㅡㅣㅣ
        ㅡㅡ,ㅡㅡㅣ   ㅣㅡㅡㅣ  ㅡㅡㅣㅣ
         */
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 2];
        dp[1] = 1;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        System.out.print(dp[n]);
        br.close();
    }
}
