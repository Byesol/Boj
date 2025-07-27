import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 5; i <= N; i *= 5) {
            count += N / i;
        }

        sb.append(count);
        System.out.println(sb);
    }
}
