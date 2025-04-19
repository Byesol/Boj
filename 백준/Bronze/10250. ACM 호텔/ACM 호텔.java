import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken()); // 사용 안하지만 형식상 필요
            int n = Integer.parseInt(st.nextToken());

            int floor = (n % h == 0) ? h : n % h;
            int room = (n % h == 0) ? n / h : n / h + 1;

            int result = floor * 100 + room;
            System.out.println(result);
        }
    }
}
