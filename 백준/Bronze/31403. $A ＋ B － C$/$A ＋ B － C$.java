import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        System.out.println(a+b-c);
        String as = String.valueOf(a);
        String bs = String.valueOf(b);
        String ab = as + bs;
        int i = Integer.parseInt(ab);
        System.out.println(i-c);
        br.close();
    }
}
