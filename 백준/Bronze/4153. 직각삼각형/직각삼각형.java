import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while (!(input = br.readLine().trim()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int max = Math.max(a, Math.max(b, c));
            int sumOfSquares = a * a + b * b + c * c - max * max;

            if (max * max == sumOfSquares) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
