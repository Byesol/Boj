class Solution {
    int answer = 0; // 전역 변수로 경우의 수 저장

    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }

    // index: 현재 인덱스, sum: 현재까지의 합
    private void dfs(int[] numbers, int target, int index, int sum) {
        // 종료 조건
        if (index == numbers.length) {
            if (sum == target) answer++;
            return;
        }

        // 선택지 2개: + / -
        dfs(numbers, target, index + 1, sum + numbers[index]);
        dfs(numbers, target, index + 1, sum - numbers[index]);
    }
}
