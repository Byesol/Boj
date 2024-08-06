import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        //그냥 5가 최대 되도록
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();



        int n = Integer.parseInt(br.readLine());
        int repeat = n/ 5; //반복횟수
        //int min = Integer.MAX_VALUE; // 굳이 필요 x? 5가 많으면 되니
        int k = 0 ;
        for(int i=repeat;i>=0;i--){
            int last = n - i*5; //나머지
             if(last%3==0){
                 k = last / 3+i;
                 sb.append(k);
                 break;

             }

        }
        if(k==0){
            sb.append(-1);
        }
        System.out.print(sb);



    }
}
