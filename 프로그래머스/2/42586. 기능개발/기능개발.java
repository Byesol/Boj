import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        //[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
        // 5   10  x   x   1   1
        //이전것보다 더 큰지를 검사
        int exday = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i< progresses.length;i++){
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if(remain%speeds[i] !=0){
                day++;
            }
            if(exday<day){
                stack.push(1);
                exday = day;
            }
            else{
                int count=  stack.pop();
                count ++;
                stack.push(count);
            }
            
        }
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }       
        return answer;
    }
}