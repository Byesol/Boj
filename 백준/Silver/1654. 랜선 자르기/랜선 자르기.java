import java.io.IOException;
import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        long max = 0; // 랜선의 최대 길이는 int 최댓값일 수 있으므로 long 사용 권장
        
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, array[i]);
        }

        long left = 1;
        long right = max + 1; 

        while(left < right){
            long cand = left + (right - left) / 2;
            long count = 0; // 만들어진 랜선 개수 누적 변수 (가장 오버플로우 나기 쉬운 곳)

            for(int i = 0; i < n; i++){
                count += array[i] / cand;
            }

            if(count >= k){
                left = cand + 1;
            }
            else{
                right = cand;
            }
        }
        
  
        System.out.println(right - 1);
    }
}