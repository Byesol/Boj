import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 정점 수
        int M = sc.nextInt(); // 간선 수
        int V = sc.nextInt(); // 시작 정점

        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 (양방향)
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        // 정점 번호 오름차순 정렬 (작은 번호 먼저 방문)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // DFS
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");

        // BFS
        visited = new boolean[N + 1];
        bfs(V);

        System.out.print(sb);
    }

    static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        for (int next : graph[v]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            sb.append(v).append(" ");

            for (int next : graph[v]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}