import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());
        Arrays.sort(array);
        int startIndex = 0;
        int endIndex = n - 1;
        while (startIndex < endIndex) {
            if (array[startIndex] + array[endIndex] == x) {
                answer++;
                startIndex++;
                endIndex--;
            } else if (array[startIndex] + array[endIndex] > x) {
                endIndex--;
            } else {
                startIndex++;
            }
        }
        System.out.print(answer);
        br.close();
    }
}
