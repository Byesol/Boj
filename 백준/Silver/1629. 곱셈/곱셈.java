import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    //   16 % 5 ==
    //  4  % 5   4 % 5
    // 16 % 6 = 4
    // (4 % 6 * 4 %6 )% 6 = 2
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long division = division(a, b, c);
        sb.append(division);
        System.out.print(sb);
        br.close();
    }

    public static long division(long a, long b, long c) {
        long result = 1;
        a = a % c;  // a가 c보다 클 수 있으므로 먼저 나머지 처리
        while (b > 0) {
            if (b % 2 == 1) {  // b가 홀수일 때
                result = (result * a) % c;
                b--;
            }
            a = (a * a) % c;  // a의 제곱을 계산
            b = b / 2;  // b를 반으로 나누기
        }
        return result;
    }
}
