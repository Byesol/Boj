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
        // -99 -2 -1 4 98
        int left = 0;
        int right = n - 1;
        int minDiff = Integer.MAX_VALUE;
        int ansLeft = array[left];
        int ansRight = array[right];

        while (left < right) {
            int sum = array[left] + array[right];
            int absSum = Math.abs(sum);

            if (absSum < minDiff) {
                minDiff = absSum;
                ansLeft = array[left];
                ansRight = array[right];
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        if (ansLeft < ansRight) {
            System.out.println(ansLeft + " " + ansRight);
        } else {
            System.out.println(ansRight + " " + ansLeft);
        }
    }
}
