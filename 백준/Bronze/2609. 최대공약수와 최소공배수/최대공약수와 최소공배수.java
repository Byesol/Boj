import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String[] split = s.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        int euclid = euclid(a, b);
        int a_last = a / euclid;
        int b_last = b / euclid;
        int max = a_last * b_last * euclid;
        sb.append(euclid).append("\n");
        sb.append(max).append("\n");
        System.out.print(sb);
        br.close();
    }

    private static int euclid(final int a, final int b) {

        int r = a % b;
        if (r == 0) {
            return b;
        } else {
            return euclid(b, r);
        }
    }
}
