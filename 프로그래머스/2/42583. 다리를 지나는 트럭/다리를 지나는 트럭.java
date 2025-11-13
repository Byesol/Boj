import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> bridge = new LinkedList<>(); // 다리(트럭 or 빈칸)
        int currentWeight = 0; // 현재 다리 전체 무게
        int time = 0;
        int idx = 0; // 다음에 올라갈 트럭 인덱스

        // 다리를 빈칸(0)으로 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (!bridge.isEmpty()) {
            time++;

            // 1) 다리에서 한 칸 전진
            currentWeight -= bridge.poll();

            // 2) 다음 트럭 올릴 수 있으면 올리기
            if (idx < truck_weights.length) {
                int nextTruck = truck_weights[idx];

                if (currentWeight + nextTruck <= weight) {
                    // 트럭 올리기
                    bridge.offer(nextTruck);
                    currentWeight += nextTruck;
                    idx++;
                } else {
                    // 못 올라가면 빈칸
                    bridge.offer(0);
                }
            }
        }

        return time;
    }
}
