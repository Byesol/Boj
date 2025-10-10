import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 1. 크기별 개수 세기
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int size : tangerine) {
            countMap.put(size, countMap.getOrDefault(size, 0) + 1);
        }

        // 2. 등장 횟수를 내림차순 정렬
        List<Integer> counts = new ArrayList<>(countMap.values());
        counts.sort(Collections.reverseOrder());

        // 3. 많이 나온 크기부터 담기
        int kinds = 0;
        for (int cnt : counts) {
            k -= cnt;
            kinds++;
            if (k <= 0) break;
        }

        return kinds;
    }
}
