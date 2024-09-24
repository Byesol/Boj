import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();


        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(array);

        int start = 0;
        int end = n - 1;
        int answer = 0;


        while (start < end) {
            int sum = array[start] + array[end];

            if (sum == m) {
                answer++;
                start++;
                end--;
            } else if (sum < m) {
                start++;
            } else {
                end--;
            }
        }

       sb.append(answer);
        System.out.println(sb);
    }
}