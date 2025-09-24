import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        int j = Integer.parseInt(br.readLine()); 

        int basketLeft = 1; 
        int basketRight = m; 
        int totalMove = 0; 

        for (int i = 0; i < j; i++) {
            int applePos = Integer.parseInt(br.readLine());

            if (applePos > basketRight) {
                int move = applePos - basketRight;
                totalMove += move;
                basketRight += move;
                basketLeft += move;
            }
            else if (applePos < basketLeft) {
                int move = basketLeft - applePos;
                totalMove += move;
                basketLeft -= move;
                basketRight -= move;
            }
        }

        System.out.println(totalMove);
        br.close();
    }
}
