import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] split = input.split("");
        int sum = 0;
        for (int i = 0; i <n ; i++) {
            sum += Integer.parseInt(split[i]);
        }
        sb.append(sum);
        System.out.print(sum);
        br.close();
    }
}
