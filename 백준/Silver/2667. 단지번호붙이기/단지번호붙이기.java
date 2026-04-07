import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

    public static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int count, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String st = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = st.charAt(j) - '0';
            }
        }
        List<Integer> answers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false && map[i][j] != 0) {
                    count = 0;
                    dfs(i, j);
                    answers.add(count);

                }
            }
        }
        System.out.println(answers.size());
        Collections.sort(answers);

        for (int answer : answers) {
            System.out.println(answer);
        }
    }
    //dfs

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ( nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == 1 &&visited[nx][ny] == false ) {
                dfs(nx, ny);

            }

        }

    }
}