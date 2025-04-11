import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number = Integer.parseInt(st.nextToken());
        int number2 = Integer.parseInt(st.nextToken());
        if (number2 < number) {
            for (int i = 0; i <6 ; i++) {
                int number3 = Integer.parseInt(st.nextToken());
                if (number3 < number2) {
                    number2 = number3;
                    continue;
                }
                else {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("descending");
            return;
        }
        if (number2 > number) {
            for (int i = 0; i <6 ; i++) {
                int number3 = Integer.parseInt(st.nextToken());
                if (number3 > number2) {
                    number2 = number3;
                    continue;
                }
                else {
                    System.out.println("mixed");
                    return;
                }
            }
            System.out.println("ascending");
            return;
        }
    }
}


