import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int rnum = Integer.parseInt(br.readLine()) ; // Intger.parseInt 를 통해 int 변환
        StringTokenizer st = new StringTokenizer(br.readLine());
        int scount = 0;
        for(int i=0;i<rnum;i++) {
            int n = Integer.parseInt(st.nextToken());
            // n에 대해 1부터 루트 n까지 나눠보면 됨?

            boolean iss = true;
            double sr = Math.sqrt(n);
            if(n ==1){
                iss = false;
            }
            else {
                for (int j = 2; j <= sr; j++) { // 딱 떨어질수도 있음
                    if (n % j == 0) {
                        iss = false;
                        break; // 더 할 필요 없으니
                    }

                }
            }
            if(iss) scount++;
            //System.out.print(n);
        }
        System.out.print(scount);
    }
}