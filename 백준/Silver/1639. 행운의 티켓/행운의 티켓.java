import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int maxLength = 0;

        int n = s.length();

        for (int len = 2; len <= n; len += 2) {
            for (int i = 0; i <= n - len; i++) {
                int mid = i + len / 2;
                int end = i + len;

                String left = s.substring(i, mid);
                String right = s.substring(mid, end);

                if (sumDigits(left) == sumDigits(right)) {
                    maxLength = Math.max(maxLength, len);
                }
            }
        }

        System.out.println(maxLength);
    }

    private static int sumDigits(String str) {
        int sum = 0;
        for (char ch : str.toCharArray()) {
            sum += ch - '0'; 
        }
        return sum;
    }
}
