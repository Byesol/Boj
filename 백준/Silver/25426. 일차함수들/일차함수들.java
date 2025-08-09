import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        long[] a = new long[N];
        long sumB = 0L;

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long ai = Long.parseLong(st.nextToken());
            long bi = Long.parseLong(st.nextToken());
            a[i] = ai;
            sumB += bi;
        }

        Arrays.sort(a); 

        long ans = sumB;
        for (int i = 0; i < N; i++) {
            long x = i + 1L;        
            ans += a[i] * x;        
        }

        System.out.println(ans);
    }
}
