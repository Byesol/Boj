import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int blueCount = 0;
    public static int whiteCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count(board);
        sb.append(whiteCount + "\n");
        sb.append(blueCount);
        System.out.print(sb);
        br.close();
    }

    private static void count(int[][] board) {
        int length = board.length;
        boolean isSame = true;
        int first = board[0][0];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] != first) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) {
                break;
            }
        }

        if (isSame) {
            if (first == 1) {
                blueCount++;
            } else {
                whiteCount++;
            }
            return;
        }
        int half = length / 2;
        int[][] leftUpBoard = new int[half][half];
        int[][] RightUpBoard = new int[half][half];
        int[][] leftDownBoard = new int[half][half];
        int[][] rightDownBoard = new int[half][half];

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                leftUpBoard[i][j] = board[i][j];
                RightUpBoard[i][j] = board[i + half][j];
                leftDownBoard[i][j] = board[i][j + half];
                rightDownBoard[i][j] = board[i + half][j + half];
            }
        }

        count(leftUpBoard);
        count(RightUpBoard);
        count(leftDownBoard);
        count(rightDownBoard);

    }
}
