import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> result = new ArrayList<>();

        int prev = -1; // arr의 값은 0~9이므로 초기값 -1 가능
        for (int num : arr) {
            if (num != prev) {
                result.add(num);
                prev = num;
            }
        }

        // List<Integer> → int[]
        return result.stream().mapToInt(i->i).toArray();
    }
}
