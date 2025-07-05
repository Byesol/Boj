import java.io.*;

public class Main {
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        int N = Integer.parseInt(size[0]);
        int M = Integer.parseInt(size[1]);

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, getMinRepaint(i, j));
            }
        }

        System.out.println(min);
    }

    static int getMinRepaint(int x, int y) {
        int repaintW = 0;  // 시작이 'W'
        int repaintB = 0;  // 시작이 'B'

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';

                if (board[x + i][y + j] != expectedW) repaintW++;
                if (board[x + i][y + j] != expectedB) repaintB++;
            }
        }

        return Math.min(repaintW, repaintB);
    }
}
