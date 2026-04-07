import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        graph = new int[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int years = 0;
        while (true) {
            int mCount = 0;
            visited = new boolean[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (graph[i][j] > 0 && !visited[i][j]) {
                        dfs(i, j);
                        mCount++;
                    }
                }
            }
            if (mCount >= 2) {
                System.out.println(years);
                return;
            } else if (mCount == 0) { // 빙산이 다 녹을 때까지 분리되지 않음
                System.out.println(0);
                return;
            }
            // 3. 빙산 녹이기 (녹을 양을 따로 저장하여 동시성 해결)
            int[][] meltAmount = new int[x][y];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (graph[i][j] > 0) {
                        int water = 0;
                        for (int l = 0; l < 4; l++) {
                            int nx = i + dx[l];
                            int ny = j + dy[l];

                            // 배열 범위 체크 및 바다(0) 체크
                            if (nx >= 0 && ny >= 0 && nx < x && ny < y) {
                                if (graph[nx][ny] == 0) {
                                    water++;
                                }
                            }
                        }
                        meltAmount[i][j] = water; // 바로 빼지 않고 기록만 해둠
                    }
                }
            }

            // 기록해둔 녹을 양을 바탕으로 일괄 업데이트
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (graph[i][j] > 0) {
                        graph[i][j] -= meltAmount[i][j];
                        if (graph[i][j] < 0) { // 높이는 음수가 될 수 없음
                            graph[i][j] = 0;
                        }
                    }
                }
            }

            // 4. 연도 증가
            years++;
        }
    }

    public static void dfs(int curX, int curY) {
        visited[curX][curY] = true;

        for (int i = 0; i < 4; i++) {
            int nx = curX + dx[i];
            int ny = curY + dy[i];

            // 배열 범위 안에 있고, 방문하지 않았으며, 빙산(높이가 0보다 큼)일 때만 탐색
            if (nx >= 0 && ny >= 0 && nx < x && ny < y) {
                if (!visited[nx][ny] && graph[nx][ny] > 0) {
                    dfs(nx, ny);
                }
            }
        }
    }
}