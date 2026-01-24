import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        // 참가자 수 카운트
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 완주자 수 차감
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        // 남은 사람이 정답
        for (String key : map.keySet()) {
            if (map.get(key) > 0) {
                return key;
            }
        }

        return "";
    }
}
