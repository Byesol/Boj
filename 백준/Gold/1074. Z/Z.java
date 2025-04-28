import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int count = 0;
    public static int result = 0; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int boardLength = (int) Math.pow(2, n);

        searchNum(0, 0, boardLength, r, c);

        System.out.println(result);
        br.close();
    }

    private static void searchNum(int startRow, int startCol, int boardLength, final int r, final int c) {
        if (boardLength == 1) { // 1칸짜리까지 내려오면
            result = count;
            return;
        }

        int half = boardLength / 2;

        // 왼위
        if (r < startRow + half && c < startCol + half) {
            searchNum(startRow, startCol, half, r, c);
        }
        // 오위
        else if (r < startRow + half && c >= startCol + half) {
            count += half * half; // 왼위칸 수 만큼 지나감
            searchNum(startRow, startCol + half, half, r, c);
        }
        // 왼아
        else if (r >= startRow + half && c < startCol + half) {
            count += 2 * half * half; // 왼위 + 오위 지나감
            searchNum(startRow + half, startCol, half, r, c);
        }
        // 오아
        else {
            count += 3 * half * half; // 왼위 + 오위 + 왼아 지나감
            searchNum(startRow + half, startCol + half, half, r, c);
        }
    }
}
