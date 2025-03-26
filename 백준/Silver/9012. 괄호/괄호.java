import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            Stack<String> stack = new Stack<>();
            boolean isValid = true;
            for (int j = 0; j < input.length(); j++) {

                char c = input.charAt(j);
                if (c == '(') {
                    stack.push("(");
                }
                if (stack.empty()) {
                    isValid = false;
                    break;
                }
                if (c == ')') {
                    stack.pop();
                }
            }
            // 결론내기
            if (stack.empty() && isValid) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
