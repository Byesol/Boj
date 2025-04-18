import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            sb.append(doCommand(input));
        }
        System.out.print(sb);

        br.close();
    }

    private static String doCommand(final String[] input) {
        String command = input[0];
        if (command.equals("push")) {
            int x = Integer.parseInt(input[1]);
            stack.push(x);
            return "";
        }
        if (command.equals("pop")) {
            if (stack.empty()) {
                return "-1\n";
            }
            return stack.pop() + "\n";
        }
        if (command.equals("size")) {
            return stack.size() + "\n";
        }
        if (command.equals("empty")) {
            if (stack.empty()) {
                return "1\n";
            }
            return "0\n";
        }
        if (command.equals("top")) {
            if (stack.empty()) {
                return "-1\n";
            }
            return stack.peek() + "\n";
        } else {
            return "erro\n";
        }

    }
}
