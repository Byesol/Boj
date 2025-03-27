import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i += 10) {
            String substring;
            if (i + 10 > input.length()) {
                substring = input.substring(i, input.length());
            } else {
                substring = input.substring(i, i + 10);

            }
            sb.append(substring + "\n");

        }
        System.out.print(sb);
        br.close();
    }
}
