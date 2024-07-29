import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];
        array[1] =0;
        //array[2] =1;
        //array[3] = 1; 초기값 이 두개가 필요할 거라 생각


        for(int i=2;i<n+1;i++){
            int min = array[i-1];
            if(i %3 ==0){
                if(array[i/3]<min){
                    min = array[i/3];
                }
            }
            if(i %2 ==0){
                if(array[i/2]<min){
                    min = array[i/2];
                }
            }
            array[i] = min+1;

        }
        sb.append(array[n]);
        System.out.print(sb);

    }
}
