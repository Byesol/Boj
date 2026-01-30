import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int size = set.size();
        if(size>nums.length/2){
            return nums.length/2;
        }
        return size;
    }
}