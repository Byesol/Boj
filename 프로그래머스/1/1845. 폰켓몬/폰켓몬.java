import java.util.*;
class Solution {
    public int solution(int[] nums) {
        // n/2 를 고르고 싶다
        // 3,3,2 가능 2,2, 3 도 가능
        // 단 핵심은 2개이상 골라야된다?
        // 일단 맵으로 다 저장
        // 최대로 하려면 어케해야지?
        // 일단 있는 애들 모두 다 고르는법 
        // set 의 개수 vs 선택한도
        int answer;
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        answer= Math.min(nums.length/2, set.size());
        return answer;
    }
}