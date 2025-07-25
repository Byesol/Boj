import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 굴다리 길이
        int M = Integer.parseInt(br.readLine()); // 가로등 개수
        int[] x = new int[M]; // 가로등 위치 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        // 가로등 위치 정렬 (보장을 위해)
        Arrays.sort(x);

        int low = 1;
        int high = N;
        int result = N;

        while (low <= high) {
            int mid = (low + high) / 2;
            boolean possible = true;

            // 첫 지점부터 커버 가능한지 확인
            if (x[0] - mid > 0) {
                possible = false;
            }

            // 각 가로등 사이의 간격 확인
            for (int i = 1; i < M; i++) {
                if (x[i] - x[i - 1] > 2 * mid) {
                    possible = false;
                    break;
                }
            }

            // 마지막 지점 커버 확인
            if (N - x[M - 1] > mid) {
                possible = false;
            }

            if (possible) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }
}
