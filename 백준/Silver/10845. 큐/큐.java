import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 빠르게 받기 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력 속도 향상을 위한 StringBuilder
        StringBuilder sb = new StringBuilder();
        
        // 명령의 개수
        int n = Integer.parseInt(br.readLine());
        
        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();
        
        // 큐의 뒤를 추적할 변수
        int back = -1;

        for (int i = 0; i < n; i++) {
            String commandLine = br.readLine();
            if (commandLine.startsWith("push")) {
                int x = Integer.parseInt(commandLine.split(" ")[1]);
                queue.offer(x);
                back = x; // 마지막 넣은 값 기억
            } else if (commandLine.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else if (commandLine.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (commandLine.equals("empty")) {
                sb.append(queue.isEmpty() ? 1 : 0).append("\n");
            } else if (commandLine.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(queue.peek()).append("\n");
                }
            } else if (commandLine.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(back).append("\n");
                }
            }
        }

        // 최종 출력
        System.out.print(sb);
    }
}
