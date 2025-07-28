import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] visited = new int[6][6];
        int[][] path = new int[36][2];
        for (int i = 0; i < 36; i++) {
            String pos = br.readLine();
            int x = pos.charAt(0) - 'A';
            int y = pos.charAt(1) - '1';
            path[i][0] = x;
            path[i][1] = y;
        }
        boolean[][] board = new boolean[6][6];
        board[path[0][0]][path[0][1]] = true;
        for (int i = 1; i < 36; i++) {
            int prevX = path[i - 1][0];
            int prevY = path[i - 1][1];
            int currX = path[i][0];
            int currY = path[i][1];
            if (!isKnightMoveValid(prevX, prevY, currX, currY)) {
                System.out.println("Invalid");
                return;
            }
            if (board[currX][currY]) {
                System.out.println("Invalid"); // 중복 방문
                return;
            }

            board[currX][currY] = true;
        }
        if (!isKnightMoveValid(path[35][0], path[35][1], path[0][0], path[0][1])) {
            System.out.println("Invalid");
            return;
        }

        System.out.println("Valid");
    }

    static boolean isKnightMoveValid(int x1, int y1, int x2, int y2) {
        for (int i = 0; i < 8; i++) {
            if (x1 + dx[i] == x2 && y1 + dy[i] == y2) {
                return true;
            }
        }
        return false;
    }
}
