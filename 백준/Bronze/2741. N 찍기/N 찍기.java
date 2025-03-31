import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int n = Integer.parseInt(input);

        for (int i = 0; i <n ; i++) {
            System.out.println(i+1);
        }

        br.close();
    }
}
