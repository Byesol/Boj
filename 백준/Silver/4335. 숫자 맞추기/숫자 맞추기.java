import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int low = 1;
        int high = 10;

        while (true) {
            int guess = Integer.parseInt(br.readLine());
            if (guess == 0) break;

            String response = br.readLine();

            if (response.equals("too high")) {
                high = Math.min(high, guess - 1);
            } else if (response.equals("too low")) {
                low = Math.max(low, guess + 1);
            } else if (response.equals("right on")) {
                if (guess < low || guess > high) {
                    sb.append("Stan is dishonest\n");
                } else {
                    sb.append("Stan may be honest\n");
                }
                low = 1;
                high = 10;
            }
        }

        System.out.print(sb);
    }
}
