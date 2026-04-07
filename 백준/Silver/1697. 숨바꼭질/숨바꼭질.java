import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int find = Integer.parseInt(st.nextToken());
        int[] time = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        time[start] = 1; // 시작점을 1로 방문 처리 (실제 정답 출력 시 -1 해줄 예정)
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (v == find) {
                System.out.println(time[v] - 1);
                return;
            }
            int[] nextPositions = {v - 1, v + 1, v * 2};
            for (int i = 0; i < 3; i++) {
                int next = nextPositions[i];
                if (next >= 0 && next <= 100000 && time[next] == 0) {
                    time[next] = time[v] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}