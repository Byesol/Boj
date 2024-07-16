import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.sqrt;
class MeetingComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        if (a[1] == b[1]) {
            return Integer.compare(a[0], b[0]);
        }
        return Integer.compare(a[1], b[1]);

    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] meetings = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meetings,new MeetingComparator());

        int count = 0;
        int endTime = 0;
        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= endTime) {
                endTime = meetings[i][1];
                count++;
            }
        }


        System.out.println(count);

    }
}
