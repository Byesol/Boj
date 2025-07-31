import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            int mod = 1 % n;
            int length = 1;

            while (mod != 0) {
                mod = (mod * 10 + 1) % n;
                length++;
            }

            System.out.println(length);
        }
    }
}
