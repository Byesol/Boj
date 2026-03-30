import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n + 1][m + 1];
        int[][] max = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max[1][1] = board[1][1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (i == 1 && j == 1) {
                    max[i][j] = board[i][j];
                } else {
                    max[i][j] = Math.max(max[i - 1][j] + board[i][j], max[i][j - 1] + board[i][j]);
                }
            }
        }
        sb.append(max[n][m]);
//        System.out.println(Arrays.deepToString(board));

//        System.out.println(Arrays.deepToString(max));
        System.out.println(sb);
        br.close();
    }
}
