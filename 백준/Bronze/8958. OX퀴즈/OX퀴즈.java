
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            int length = input.length();
            int point = 0;
            int plusPoint = 1;
            for (int j = 0; j < length; j++) {
                if (input.charAt(j) == 'O') {
                    point += plusPoint;
                    plusPoint++;
                } else {
                    plusPoint = 1;
                }
            }
            bw.append(String.format("%d\n", point));

        }

        bw.flush();
        br.close();
        bw.close();
    }
}