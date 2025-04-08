import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int solution = solution(n);
        System.out.println(solution);

    }

    public static int solution(int n) {
        if (n > 1) {
            return n * solution(n - 1);
        } else {
            return 1;
        }
    }
}
