import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int graph[][];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()); // 가로
        int n = Integer.parseInt(st.nextToken()); // 세로

        Queue<int[]> queue = new LinkedList<>();

        graph = new int[n][m];

        // 1. 맵 입력 받기 & 익은 토마토(1) 큐에 미리 다 넣어두기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) {
                    queue.offer(new int[]{i, j}); // 여러 시작점이 모두 큐에 들어감
                }
            }
        }
        //bfs
        while (!queue.isEmpty()) {
            int[] v = queue.poll();
            int x = v[0];
            int y = v[1];

            for (int i = 0; i < 4; i++) {
                int nx = v[0] + dx[i];
                int ny = v[1] + dy[i];
                // 범위 내
                // 안 익은 토마토라면
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = graph[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }

                }
            }
        }

        int maxDays = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                // 배열에 적힌 숫자 중 가장 큰 숫자를 찾습니다.
                maxDays = Math.max(maxDays, graph[i][j]);
            }
        }
        System.out.println(maxDays - 1); // 처음 익은 토마토는 1로 시작했으므로, 최종 결과에서 1을 빼줍니다.

    }


}