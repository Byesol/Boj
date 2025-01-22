import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        boolean result = true;

        int n = Integer.parseInt(br.readLine());
        //n번 반복
        int[] array = new int[n];
        Stack<Integer> stack = new Stack<>();
        int num =1;
        for(int i=0;i<n;i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        //n개의 입력받은 수들에 대해 걔네를  +와 -로 표현해야한다.
        for(int i=0;i<n;i++){
            // k = 목표 수
            int k = array[i];
            //일단 스택에다 num을 목표수와 똑같아질때까지 넣는다.
            if(k>=num){
                while(k>=num) {
                    stack.push(num);
                    num++;
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }

            //스택에 들어간 num이 더 작은 경우(스택 안에 해당 수 존재)
            else{
                int last = stack.pop();
                if(last>k){
                    result=false;
                    System.out.println("NO");
                    break;
                }
                else{
                    sb.append("-\n");
                }
            }

            //num을 스택에서 pop한다.
            //뺄때는?

        }
        if(result) {
            System.out.println(sb);
        }

    }

}