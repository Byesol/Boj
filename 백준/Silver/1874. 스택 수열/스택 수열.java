import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        stack.push(0);
        int j=1;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            if((j>s) && stack.peek()<s){
                System.out.print("NO");
                return;
            }
            while(j<=s){
                stack.push(j);
                sb.append("+\n");
                j++;
            }
            while (stack.peek()>=s){
                stack.pop();
                sb.append("-\n");
            }
        }
        System.out.print(sb);
    }
}
