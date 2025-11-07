import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        // 이동 방향: 상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // BFS를 위한 큐
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0}); // 시작 위치

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            // 목표 도착 시 거리 반환
            if (x == n - 1 && y == m - 1) {
                return maps[x][y];
            }

            // 4방향 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                // 범위 검사 + 길 확인
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                    // 이동 거리 갱신
                    maps[nx][ny] = maps[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        // 도달 불가능 시
        return -1;
    }
}
