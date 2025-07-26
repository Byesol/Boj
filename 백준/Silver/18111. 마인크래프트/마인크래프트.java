import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[][] land = new int[N][M];
        int min = 256;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                land[i][j] = height;
                min = Math.min(min, height);
                max = Math.max(max, height);
            }
        }
        int resultTime = Integer.MAX_VALUE;
        int resultHeight = -1;
        for (int target = min; target <= max; target++) {
            int time = 0;
            int inventory = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int diff = land[i][j] - target;

                    if (diff > 0) {

                        time += diff * 2;
                        inventory += diff;
                    } else if (diff < 0) {
                      
                        time += (-diff);
                        inventory -= (-diff);
                    }
                }
            }
            if (inventory >= 0) {
                if (time < resultTime || (time == resultTime && target > resultHeight)) {
                    resultTime = time;
                    resultHeight = target;
                }
            }
        }

        System.out.println(resultTime + " " + resultHeight);
    }
}
