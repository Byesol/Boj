import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); //arraylist 형태로 그래프 구현
        for(int i = 0 ; i <= n ; i++) graph.add(new ArrayList<>());

        for(int i=0;i<m;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n + 1];

        int num =0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                num++;
                dfs(i, graph, visited);
            }
        }
        System.out.print(num);

    }
    // DFS 구현
    public static void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

}
