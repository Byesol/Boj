import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(st.nextToken());
            sb.append(countByBinarySearch(array, find)).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    private static int countByBinarySearch(int[] array, int find) {
        return upperBound(array, find) - lowerBound(array, find);
    }

    private static int lowerBound(int[] array, int target) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int upperBound(int[] array, int target) {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
