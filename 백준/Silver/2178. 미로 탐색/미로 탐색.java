import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] graph;
    public static int[][] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n + 1][m + 1]; // 1, 1에서 출발하니까
        count = new int[n + 1][m + 1];
        //bfs라 보면
        // 각각이 노드고 자기 주위는 싹 다 방문해야돼
        // 방문을 그냥 따로 배열 안 두고 2로표시
        // 방문했던 데 count는 어케 세지? count가 하나면 안 돼 그러면 옆으로 새어나가는 길에서 오류 발생
        // count는 노드로 따지면 레벨.. 레벨을 어케 셀까?
        // 각각의 노드마다 레벨이 있음 그 레벨은 누구로부터 왔느냐로 정해질듯 일종의 스택? 아닌가?
        // 미로에 표시?
        for (int i = 1; i <= n; i++) {
            String input = br.readLine(); 
            for (int j = 1; j <= m; j++) {
                graph[i][j] = input.charAt(j - 1) - '0'; 
            }
        }
        int row = 1;
        int column = 1;

        bfs(n, m);
        System.out.print(count[n][m]);
    }

    private static void bfs(int n, int m) {
        Queue<int[]> queue = new LinkedList<>(); //순서 유지하려고 큐씀 니들 차례대로 하자 마인드
        queue.add(new int[]{1, 1});
        graph[1][1] = 2; // 방문 표시
        count[1][1] = 1; // 시작점 거리 1

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int r = now[0];
            int c = now[1];

            // 위로 이동 끄트머리 체크
            if (r - 1 >= 1 && graph[r - 1][c] == 1) {
                queue.add(new int[]{r - 1, c}); //나도 해줘요 일단 찜콩 바로 끝까지 갈 필요없으니까 큐에 추가하는 걸로 끝
                graph[r - 1][c] = 2;
                count[r - 1][c] = count[r][c] + 1;
            }

            // 아래로 이동
            if (r + 1 <= n && graph[r + 1][c] == 1) {
                queue.add(new int[]{r + 1, c});
                graph[r + 1][c] = 2;
                count[r + 1][c] = count[r][c] + 1;
            }

            // 왼쪽으로 이동
            if (c - 1 >= 1 && graph[r][c - 1] == 1) {
                queue.add(new int[]{r, c - 1});
                graph[r][c - 1] = 2;
                count[r][c - 1] = count[r][c] + 1;
            }

            // 오른쪽으로 이동
            if (c + 1 <= m && graph[r][c + 1] == 1) {
                queue.add(new int[]{r, c + 1});
                graph[r][c + 1] = 2;
                count[r][c + 1] = count[r][c] + 1;
            }
        }
    }


}
