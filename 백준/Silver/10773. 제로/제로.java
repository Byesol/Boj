import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        // 1. n 만큼 입력 받고 저장하기
        // 2. 0이 나올 경우 최근 거 제거
        //3. 합 구하기
        Stack<Integer> sumStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int input = Integer.parseInt(st.nextToken());
            if (input == 0) {
                sumStack.pop();
                continue;
            }
            sumStack.push(input);
        }
        int sum = 0;
        while (!sumStack.empty()) {
            sum += sumStack.pop();
        }
        sb.append(sum);
        System.out.print(sb);
        br.close();
    }
}
