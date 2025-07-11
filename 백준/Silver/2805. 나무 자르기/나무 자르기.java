import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무 수
        int m = Integer.parseInt(st.nextToken()); // 필요한 나무 길이

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        // 이분 탐색 시작
        long start = 0;
        long end = max;
        long result = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    total += tree - mid;
                }
            }

            if (total >= m) {
                result = mid;     
                start = mid + 1;
            } else {
                end = mid - 1;   
            }
        }

        System.out.println(result);
    }
}
