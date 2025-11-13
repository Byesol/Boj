import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        int baseDay = calc(progresses[0], speeds[0]);
        int count = 1;

        for (int i = 1; i < progresses.length; i++) {
            int day = calc(progresses[i], speeds[i]);
            
            if (day <= baseDay) {
                count++;
            } else {
                answer.add(count);
                baseDay = day;
                count = 1;
            }
        }

        answer.add(count);
        return answer.stream().mapToInt(i -> i).toArray();
    }

    private int calc(int progress, int speed) {
        int remain = 100 - progress;
        return (remain + speed - 1) / speed; // 올림
    }
}
