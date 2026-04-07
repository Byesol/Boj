import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int[][][] graph;
    // 6방향 (상, 하, 좌, 우, 위, 아래)
    static int[] dh = {0, 0, 0, 0, 1, -1}; // 높이 (z)
    static int[] dn = {0, 0, 1, -1, 0, 0}; // 세로 (y)
    static int[] dm = {1, -1, 0, 0, 0, 0}; // 가로 (x)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로
        int h = Integer.parseInt(st.nextToken()); // 높이

        // 배열 순서: [높이][세로][가로]
        graph = new int[h][n][m];
        Queue<int[]> queue = new LinkedList<>();

        // 1. 입력 받기 (순서 주의: 높이 -> 세로 -> 가로)
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                // 세로(행)가 바뀔 때마다 새로운 줄을 읽어야 합니다!
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    // 1이면 queue에 넣는다 (좌표 순서도 h, n, m)
                    if (graph[i][j][k] == 1) {
                        queue.offer(new int[]{i, j, k});
                    }
                }
            }
        }

        // 2. BFS 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int ch = current[0]; // 높이
            int cn = current[1]; // 세로
            int cm = current[2]; // 가로

            for (int i = 0; i < 6; i++) {
                int nh = ch + dh[i];
                int nn = cn + dn[i];
                int nm = cm + dm[i];

                // 범위 내에 있고 (h, n, m 각각의 최대 크기와 비교)
                if (nh >= 0 && nh < h && nn >= 0 && nn < n && nm >= 0 && nm < m) {
                    // 안 익은 토마토라면
                    if (graph[nh][nn][nm] == 0) {
                        graph[nh][nn][nm] = graph[ch][cn][cm] + 1;
                        queue.offer(new int[]{nh, nn, nm});
                    }
                }
            }
        }

        // 3. 결과 확인
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    // 안 익은 토마토가 하나라도 있으면 -1 출력 후 즉시 종료
                    if (graph[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    max = Math.max(max, graph[i][j][k]);
                }
            }
        }
        
        // 걸린 일수 출력
        System.out.println(max - 1);
    }
}