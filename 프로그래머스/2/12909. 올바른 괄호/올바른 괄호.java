class Solution {
    boolean solution(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                if (count == 0) return false; // 닫는 괄호인데 열린 괄호가 없음
                count--;
            }
        }
        return count == 0; // 모두 짝이 맞으면 0
    }
}
