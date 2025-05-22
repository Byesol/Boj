import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

  
        int[][] cost = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(cost[i], MAX_VALUE);
            cost[i][i] = 0;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[u][v] = Math.min(cost[u][v], c);
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] eachDistance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        int[] prevCity = new int[n + 1];

        Arrays.fill(eachDistance, MAX_VALUE);
        eachDistance[a] = 0;

        for (int i = 1; i <= n; i++) {

            int shortestCity = 0, min = MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && eachDistance[j] < min) {
                    min = eachDistance[j];
                    shortestCity = j;
                }
            }
            if (shortestCity == 0) {
                break;
            }
            visited[shortestCity] = true;

            for (int city = 1; city <= n; city++) {
                if (!visited[city]
                        && cost[shortestCity][city] != MAX_VALUE
                        && eachDistance[city] > eachDistance[shortestCity] + cost[shortestCity][city]) {

                    eachDistance[city] = eachDistance[shortestCity] + cost[shortestCity][city];
                    prevCity[city] = shortestCity;  // city로 올 때 바로 전이 shortestCity 모든 노드에  shortest 시 바로 전만 기록하면 경로 구할 수 있다
                }
            }
        }

        // 루트 복원 B -> A 순으로
        List<Integer> path = new ArrayList<>();
        for (int current = b; current != 0; current = prevCity[current]) {
            path.add(current);
            if (current == a) {
                break;
            }
        }
        Collections.reverse(path);

        sb.append(eachDistance[b]).append('\n');
        sb.append(path.size()).append('\n');
        for (int city : path) {
            sb.append(city).append(' ');
        }
        System.out.print(sb);
    }
}
