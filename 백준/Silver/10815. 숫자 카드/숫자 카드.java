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
        int first = 0;
        int end = n - 1;
        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(st.nextToken());
            int result = binarySearch(find, array, first, end);
            sb.append(result+" ");
        }
        System.out.print(sb );
        br.close();
    }

    public static int binarySearch(int find, int[] array, int first, int end) {

        int mid = (first + end) / 2;
        if (first > end) {

            return 0;
        }
        if (array[mid] == find) {
            return 1;
        }
        if (array[mid] > find) {
            return binarySearch(find, array, first, mid - 1);
        }
        if (array[mid] < find) {
            return binarySearch(find, array, mid + 1, end);
        }
        return 0;

    }
}
