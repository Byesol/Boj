import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0, end = 0;
        long sum = 0;      
        int count = 0;

        while (true) {
            if (sum >= m) {
                if (sum == m) count++;
                sum -= array[start++];
            } else {
                if (end == n) break; 
                sum += array[end++];
            }
        }

        System.out.println(count);
        br.close();
    }
}
