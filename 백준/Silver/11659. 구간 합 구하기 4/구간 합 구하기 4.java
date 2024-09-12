import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int  n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] s = new int[n+1];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 1; i<n+1;i++){ // s[0]엔 0들어가 있음

            int k = Integer.parseInt(st2.nextToken());

            s[i] = s[i-1] + k;

        }

        for(int i=0; i<m; i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st3.nextToken());
            int e = Integer.parseInt(st3.nextToken());
            sb.append(s[e] - s[f-1]).append("\n");
        }
        System.out.print(sb);

    }
}