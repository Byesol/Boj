import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    static List<Integer>[] graph;     // 바깥: 배열, 안쪽: ArrayList
    static boolean[] visitedForDfs;
    static boolean[] visitedForBfs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        // 1️⃣ 그래프 초기화 (바깥 배열, 안쪽 ArrayList)
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        // 2️⃣ 간선 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        // 3️⃣ 탐색 순서를 위해 각 리스트 정렬
        for (int i = 1; i <= n; i++) Collections.sort(graph[i]);

        visitedForDfs = new boolean[n + 1];
        dfs(v);
        sb.append("\n");

        visitedForBfs = new boolean[n + 1];
        bfs(v);

        System.out.print(sb);
        br.close();
    }

    // 4️⃣ DFS
    public static void dfs(int start) {
        visitedForDfs[start] = true;
        sb.append(start).append(" ");
        for (int next : graph[start]) {
            if (!visitedForDfs[next]) dfs(next);
        }
    }

    // 5️⃣ BFS
    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visitedForBfs[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            for (int next : graph[now]) {
                if (!visitedForBfs[next]) {
                    visitedForBfs[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
