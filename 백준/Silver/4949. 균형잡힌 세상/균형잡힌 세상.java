import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;
        while (!(input = br.readLine()).equals(".")) {
            sb.append(resultOfBalance(input));
        }
        System.out.print(sb);
        br.close();
    }

    private static String resultOfBalance(final String input) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {

            String element = "a";
            if (input.charAt(i) == '(') {
                stack.push("(");
            }
            if (input.charAt(i) == '[') {
                stack.push("[");

            }
            if (input.charAt(i) == ')') {
                if (stack.empty()) {
                    return "no\n";
                }
                if (stack.peek() != "(") {
                    return "no\n";
                }
                stack.pop();
            }
            if (input.charAt(i) == ']') {
                if (stack.empty()) {
                    return "no\n";
                }
                if (stack.peek() != "[") {
                    return "no\n";
                }
                stack.pop();
            }
        }
        if (stack.empty()) {
            return "yes\n";
        }
        return "no\n";
    }
}
