import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter((new OutputStreamWriter(System.out)));
        ArrayDeque<Integer> que=new ArrayDeque<>();
        int n=Integer.valueOf(br.readLine());
        for(int i=n; i>=1; i--){
            if(i%2==0){
                que.addFirst(i);
            }
            else{
                que.addLast(i);
            }
        }
        while(!que.isEmpty()){
            bw.write(que.pollFirst()+" ");
        }
        bw.flush();
    }
}

