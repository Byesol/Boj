import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int goodWordCount = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (char c : word.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();  
                } else {
                    stack.push(c); 
                }
            }

            if (stack.isEmpty()) {
                goodWordCount++;  
            }
        }

        System.out.println(goodWordCount);
    }
}
