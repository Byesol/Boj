class Solution {
    int answer = 0;
    int[] numbers;
    int target;

    public int solution(int[] numbers, int target) {
        this.numbers= numbers;
        this.target = target;
        dfs(0,  0);
        return answer;
    }
    private void dfs(int depth, int calc) {
        if (depth == numbers.length) {
            if (calc == target) {
                answer++;
            }
            
            return;
        } else {
            dfs(depth + 1, calc + numbers[depth]);
            dfs( depth + 1,  calc - numbers[depth]);
        }
    }
}