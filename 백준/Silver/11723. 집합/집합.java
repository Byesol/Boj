import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int s = 0;
        StringTokenizer st;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int x = 0;
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (cmd) {
                case "add":
                    s = s | (1 << (x - 1));
                    break;
                case "remove":
                    s = s & ~(1 << (x - 1));
                    break;
                case "check":
                    sb.append((s & (1 << (x - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    s = s^ (1 << (x - 1));
                    break;
                case "all":
                    s = (1 << 20) - 1;
                    break;
                case "empty":
                    s = 0;
                    break;
            }
        }
        System.out.print(sb);
    }
}
