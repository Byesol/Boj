import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // --- 1) 입력 준비 ---
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

    
        int N = Integer.parseInt(br.readLine().trim());
        long[] courseMask = new long[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            long courseTime = 0L;
            for (int j = 0; j < k; j++) {
                int t = Integer.parseInt(st.nextToken());
                courseTime = courseTime | 1L << (t - 1); 
            }
            courseMask[i] = courseTime;
        }
        
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            long studentMask = 0L;
            for (int j = 0; j < p; j++) {
                int q = Integer.parseInt(st.nextToken());
                studentMask = studentMask | 1L << (q - 1);
            }


            int cnt = 0;
            for (long cm : courseMask) {
                if ((cm & studentMask) == cm) {
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }
}
