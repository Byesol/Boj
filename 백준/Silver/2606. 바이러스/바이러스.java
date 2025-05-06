import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][] graph;
    public static boolean[] visited;
    public static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1]; // 방문 여부

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        dfs(1, n); // 1번 컴퓨터에서 시작
        System.out.print(count);
    }

    private static void dfs(int start, int n) {
        visited[start] = true;

        for (int i = 1; i <= n; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                count++; // 1번은 포함 안 하니까 여기
                dfs(i, n);
            }
        }
    }
}
