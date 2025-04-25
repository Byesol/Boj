import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j) - '0';
                //띄어쓰기 안 되어있기에 nextToken으로 해결이 안됨
            }
        }
        blackAndWhite(board);
        System.out.print(sb);
        br.close();
    }

    private static void blackAndWhite(int[][] board) {

        int length = board.length;
        int first = board[0][0];
        boolean isSame = true;
        for (int i = 0; i < length; i++) {
            if (!isSame) {
                break;
            }
            for (int j = 0; j < length; j++) {
                if (board[i][j] != first) {
                    isSame = false;
                    break;

                }
            }
        }
        if (isSame) {
            sb.append(first);
            return;
        }
        //서로 같지 않다는 게 확정됨
        sb.append("(");
        int half = length / 2;
        int[][] leftUpBoard = new int[half][half];
        int[][] leftDown = new int[half][half];
        int[][] rightUp = new int[half][half];
        int[][] rightDownBoard = new int[half][half];

        for (int i = 0; i < half; i++) {
            for (int j = 0; j < half; j++) {
                leftUpBoard[i][j] = board[i][j];
                rightUp[i][j] = board[i][j + half];
                leftDown[i][j] = board[i + half][j];
                rightDownBoard[i][j] = board[i + half][j + half];
            }
        }

        blackAndWhite(leftUpBoard);
        blackAndWhite(rightUp);
        blackAndWhite(leftDown);
        blackAndWhite(rightDownBoard);
        sb.append(")");
    }
}
