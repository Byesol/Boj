import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // 시작점 세팅: 문제에서 처음 위치도 1칸으로 세므로 거리는 1부터 시작
        queue.offer(new int[]{0, 0, 1}); 
        maps[0][0] = 0; // 시작점 방문 처리
        
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            int currentX = v[0];
            int currentY = v[1];
            int currentDist = v[2]; // 현재까지 이동한 거리
            
            // 목적지에 도착한 경우 바로 거리를 반환
            if(currentX == n - 1 && currentY == m - 1){
                return currentDist;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];
                
                // 1. 맵을 벗어나지 않도록 범위 체크 (필수!)
                if(nx >= 0 && ny >= 0 && nx < n && ny < m){
                    // 2. 벽이 아니고 갈 수 있는 길(1)인 경우
                    if(maps[nx][ny] == 1){
                        // 이동 거리를 1 증가시켜서 큐에 삽입
                        queue.offer(new int[]{nx, ny, currentDist + 1});
                        maps[nx][ny] = 0; // 큐에 넣음과 동시에 방문 처리
                    }
                }
            } // for문 종료
        } // while문 종료
        
        return -1; // 큐가 다 빌 때까지 도착하지 못하면 -1 반환
    } // solution 메서드 종료
}