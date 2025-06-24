import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxScore = 0;
        int winner = 0;

        for (int i = 1; i <= 5; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += sc.nextInt();
            }

            if (sum > maxScore) {
                maxScore = sum;
                winner = i;
            }
        }

        System.out.println(winner + " " + maxScore);
    }
}
