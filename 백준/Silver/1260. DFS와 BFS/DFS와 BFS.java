import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1]; // 1-based index
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        boolean[] visitedForDfs = new boolean[n + 1];
        dfs(graph, visitedForDfs, v);
        sb.append("\n");

        boolean[] visitedForBfs = new boolean[n + 1];
        bfs(graph, visitedForBfs, v);
        System.out.print(sb);

        br.close();
    }

    public static void dfs(int[][] graph, boolean[] visited, int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int i = 1; i < graph.length; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    public static void bfs(int[][] graph, boolean[] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");

            for (int i = 1; i < graph.length; i++) {
                if (graph[now][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
