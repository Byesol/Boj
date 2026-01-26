import java.util.*;
class Solution {
    public int solution(int[] citations) {
        // 6 5 3 1 0  
        //     3번째, 3이상  4번째, 4이상
        // 0 1 3 5 6
        //         
        Arrays.sort(citations);
        int answer = 0;
        for(int j=citations.length-1;j>=0;j--){
            if(citations[j] >= citations.length - j){
                answer = citations.length - j;
            }
        }
        return answer;
    }
}