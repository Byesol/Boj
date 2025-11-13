import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        // 1. 기능별 완료까지 필요한 일수 계산
        List<Integer> needDays = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if (remain % speeds[i] != 0) day++;
            needDays.add(day);
        }

        // 2. 배포 그룹 만들기
        List<Integer> result = new ArrayList<>();
        int currentDeployDay = needDays.get(0);
        int count = 1;

        for (int i = 1; i < needDays.size(); i++) {
            if (needDays.get(i) <= currentDeployDay) {
                // 같은 배포날에 포함
                count++;
            } else {
                // 이전 배포 세트 확정
                result.add(count);
                // 새로운 배포 그룹 시작
                currentDeployDay = needDays.get(i);
                count = 1;
            }
        }

        // 마지막 그룹 추가
        result.add(count);

        // 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}
