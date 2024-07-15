import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);

        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;

        for (int value : sortedArray) {
            if (!map.containsKey(value)) {
                map.put(value, index++);
            }
        }

        for (int each : array) {
            sb.append(map.get(each)).append(" ");
        }

        System.out.print(sb.toString().trim());
    }
}
