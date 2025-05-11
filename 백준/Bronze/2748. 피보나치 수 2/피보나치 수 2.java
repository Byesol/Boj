import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] array = new long[100];
        // 날먹.. time is gold
        array[0] = 0;
        array[1] = 1;
        array[2] = 1;
        int n = Integer.parseInt(br.readLine());
        for (int i = 2; i < n + 1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        sb.append(array[n]);
        System.out.print(sb);

        br.close();
    }
}
