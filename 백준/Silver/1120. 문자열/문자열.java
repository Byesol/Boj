import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        int aLen = a.length();
        int bLen = b.length();

        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= bLen - aLen; i++) {
            int same = 0;
            for (int j = 0; j < aLen; j++) {
                if (b.charAt(i + j) == a.charAt(j)) {
                    same++;
                }
            }
            max = Math.max(max, same);
        }

        System.out.println(aLen - max);
    }
}
