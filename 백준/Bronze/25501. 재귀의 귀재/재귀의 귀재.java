import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int[] count = new int[1]; // 호출 횟수를 담을 배열
            int palindrome = isPalindrome(input, count);
            sb.append(palindrome).append(" ").append(count[0]).append("\n");
        }
        System.out.print(sb);
    }

    public static int isPalindrome(String input, int[] count) {
        return repeat(input, 0, input.length() - 1, count);
    }

    public static int repeat(String input, int start, int finish, int[] count) {
        count[0]++;
        if (start >= finish) {
            return 1;
        }
        if (input.charAt(start) != input.charAt(finish)) {
            return 0;
        }
        return repeat(input, start + 1, finish - 1, count);
    }
}
