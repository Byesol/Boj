import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int answer=0;

        int start =1;
        int end=1;
        int sum=1;

        while(start<=end){
            if(sum==n){
                answer++;
            }
            if(sum<n){
                end++;
                sum+=end;
            }
            else if(sum>=n){
                sum -=start;
                start++;
            }
        }
        sb.append(answer);
        System.out.println(sb);




    }
}