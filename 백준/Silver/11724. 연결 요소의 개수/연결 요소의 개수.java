import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];
        int count = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }
        System.out.print(count);
        br.close();
    }

    public static void dfs(int[][] graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int i = 1; i < n + 1; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }
}
