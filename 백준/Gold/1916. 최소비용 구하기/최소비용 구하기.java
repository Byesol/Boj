import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 1) N, M 읽기
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 2) 그래프(비용) 초기화: 1~N
        int[][] cost = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(cost[i], INF);
        }
        // 자기 자신으로 가는 비용은 0
        for (int i = 1; i <= N; i++) {
            cost[i][i] = 0;
        }

        // 3) M개의 버스 정보 입력
        //    동일 방향에 여러 간선이 있을 수 있으니, 최소값만 저장
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (c < cost[u][v]) {
                cost[u][v] = c;
            }
        }

        // 4) 출발 A, 도착 B 읽기
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 5) 다익스트라 준비
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(dist, INF);
        dist[A] = 0;

        // 6) 다익스트라 (O(N^2))
        for (int i = 1; i <= N; i++) {
            // 6-1) 아직 방문 안 한 정점 중에서 dist 최솟값의 정점 u 선택
            int u = -1;
            int min = INF;
            for (int j = 1; j <= N; j++) {
                if (!visited[j] && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }
            if (u == -1) break;      // 더 갈 수 있는 정점이 없으면 종료
            visited[u] = true;

            // 6-2) u를 거쳐 다른 정점 v로 가는 경로를 확인해서 dist 갱신
            for (int v = 1; v <= N; v++) {
                if (!visited[v] && cost[u][v] != INF) {
                    if (dist[v] > dist[u] + cost[u][v]) {
                        dist[v] = dist[u] + cost[u][v];
                    }
                }
            }
        }

        // 7) 결과 출력
        System.out.println(dist[B]);
    }
}
