import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numbers);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int find = Integer.parseInt(st.nextToken());
            int mid = (numbers.size() - 1) / 2;
            int start = 0;
            int last = numbers.size() - 1;
            boolean result = binarySearch(find, start, mid, last);
            if (result) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }
        System.out.print(sb);

        br.close();
    }

    private static boolean binarySearch(int find, int start, int mid, int last) {
        if (find == numbers.get(mid)) {
            return true;
        }
        if (start > last) {
            return false;
        }
        if (find > numbers.get(mid)) {
            ;
            int newMid = (mid + last + 1) / 2;
            return binarySearch(find, mid + 1, newMid, last);
        }
        if (find < numbers.get(mid)) {
            int newMid = (mid + start - 1) / 2;
            return binarySearch(find, start, newMid, mid - 1);
        }
        return false;
    }
}
