import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 카운트 변수 선언
    public static int minusOneCount = 0;
    public static int zeroCount = 0;
    public static int oneCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[][] paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divideAndCount(paper, 0, 0, n);

        sb.append(minusOneCount).append("\n");
        sb.append(zeroCount).append("\n");
        sb.append(oneCount).append("\n");

        System.out.print(sb);
        br.close();
    }

    private static void divideAndCount(int[][] paper, int x, int y, int size) {
        // 크기가 1이면 그 값을 바로 카운트
        if (size == 1) {
            if (paper[x][y] == -1) minusOneCount++;
            else if (paper[x][y] == 0) zeroCount++;
            else if (paper[x][y] == 1) oneCount++;
            return;
        }

        int firstValue = paper[x][y];
        boolean isSame = true;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != firstValue) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        if (isSame) {
            if (firstValue == -1) minusOneCount++;
            else if (firstValue == 0) zeroCount++;
            else if (firstValue == 1) oneCount++;
        } else {
            int newSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    divideAndCount(paper, x + i * newSize, y + j * newSize, newSize);
                }
            }
        }
    }
}
