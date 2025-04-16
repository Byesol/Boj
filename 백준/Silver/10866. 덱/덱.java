import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> numbers = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push_front":
                    numbers.addFirst(Integer.parseInt(input[1]));
                    break;
                case "push_back":
                    numbers.addLast(Integer.parseInt(input[1]));
                    break;
                case "pop_front":
                    if (numbers.isEmpty()) sb.append("-1\n");
                    else sb.append(numbers.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if (numbers.isEmpty()) sb.append("-1\n");
                    else sb.append(numbers.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(numbers.size()).append("\n");
                    break;
                case "empty":
                    sb.append(numbers.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    if (numbers.isEmpty()) sb.append("-1\n");
                    else sb.append(numbers.getFirst()).append("\n");
                    break;
                case "back":
                    if (numbers.isEmpty()) sb.append("-1\n");
                    else sb.append(numbers.getLast()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}
