import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 크기별 개수 세기
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int t : tangerine) {
            countMap.put(t, countMap.getOrDefault(t, 0) + 1);
        }
        
        // 빈도수 내림차순 정렬
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort(Collections.reverseOrder());
        
        int answer = 0;
        int total = 0;
        
        // 빈도 높은 것부터 k개 채우기
        for (int count : counts) {
            answer++;
            total += count;
            if (total >= k) break;
        }
        
        return answer;
    }
}