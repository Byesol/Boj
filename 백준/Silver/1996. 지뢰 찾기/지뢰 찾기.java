import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] inputMap = new char[n][n];
        int[][] result = new int[n][n];
        boolean[][] isMine = new boolean[n][n];

        // 입력 받기
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            inputMap[i] = line.toCharArray();
            for (int j = 0; j < n; j++) {
                if (Character.isDigit(inputMap[i][j])) {
                    isMine[i][j] = true;
                    int mineCount = inputMap[i][j] - '0';
                    for (int d = 0; d < 8; d++) {
                        int ni = i + dx[d];
                        int nj = j + dy[d];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && !isMine[ni][nj]) {
                            result[ni][nj] += mineCount;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isMine[i][j]) {
                    sb.append('*');
                } else if (result[i][j] >= 10) {
                    sb.append('M');
                } else {
                    sb.append(result[i][j]);
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
