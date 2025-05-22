import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] cost = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(cost[i], MAX_VALUE); // 검색 통해 획득
        }

        for (int i = 1; i <= n; i++) {
            cost[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            cost[u][v] = Math.min(cost[u][v], c); // 같은 경로 버스 두개일경우 고려
        }
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 각각에 도시에 가는 거리들 저장용, 방문 여부 저장용
        int[] eachDistance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(eachDistance, MAX_VALUE);
        eachDistance[A] = 0;

        for (int i = 1; i <= n; i++) {
            //  아직 방문 안 한 도시 중에서 dist 가장 가까운 곳 선택
            int shortestCity = 0;
            int min = MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                if (!visited[j] && eachDistance[j] < min) {
                    min = eachDistance[j];
                    shortestCity = j;
                }
            }
            if (shortestCity == 0) {
                break;      // 이제 갈 데가 없음
            }
            visited[shortestCity] = true;

            // 방금 계산한 city 를 거쳐 다른 city 로 가는 경로를 확인해서 도시별 거리 지도 갱신
            for (int city = 1; city <= n; city++) {
                if (!visited[city] && cost[shortestCity][city] != MAX_VALUE) {
                    if (eachDistance[city] > eachDistance[shortestCity] + cost[shortestCity][city]) {
                        eachDistance[city] = eachDistance[shortestCity] + cost[shortestCity][city];
                    }
                }
            }
        }

        System.out.println(eachDistance[B]);
    }
}
