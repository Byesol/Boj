import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력을 문자열로 받음
        String s = br.readLine();

        // 문자열을 문자 배열로 변환
        char[] chars = s.toCharArray();

        // 오름차순 정렬 후 뒤에서부터 출력
        Arrays.sort(chars);

        // 내림차순으로 출력
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }

        br.close();
    }
}
