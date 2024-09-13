import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        long[] A = new long[n+1]; // 부분합 배열
        long[] R = new long[m];

        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<n+1;i++){
            A[i] = A[i-1]+Long.parseLong(st.nextToken());
        }
        for(int i=1;i<n+1;i++){
            int remain = (int) (A[i] % m);
            if(remain == 0){answer++;}
            R[remain]++;
        }

        for(int i=0;i<m;i++){
            answer += (R[i]* (R[i]-1))/2;
        }
        sb.append(answer);
        System.out.print(answer);

    }
}