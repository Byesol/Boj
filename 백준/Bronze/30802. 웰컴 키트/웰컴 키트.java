import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result1 = 0;
        for (int i = 0; i < 6; i++) {
            if (nums.get(i) == 0) {
                continue;
            }
            result1 += ((nums.get(i) - 1) / t + 1);
        }
        int result2 = n / p;
        int result3 = n % p;

        System.out.println(result1);
        System.out.println(result2 + " " + result3);

        br.close();
    }
}
