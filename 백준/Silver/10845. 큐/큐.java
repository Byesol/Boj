import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        Queue<Integer> queue = new LinkedList<>();
        
        int back = -1;

        for (int i = 0; i < n; i++) {
            String commandLine = br.readLine();
            if (commandLine.startsWith("push")) {
                int x = Integer.parseInt(commandLine.split(" ")[1]);
                queue.offer(x);
                back = x; // 마지막 넣은 값 기억
            }
            if (commandLine.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } 
            if (commandLine.equals("size")) {
                sb.append(queue.size()).append("\n");
            } 
            if (commandLine.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            }  
            if (commandLine.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
            }  
            if (commandLine.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(back).append("\n");
                }
            }
        }

      
        System.out.print(sb);
    }
}
