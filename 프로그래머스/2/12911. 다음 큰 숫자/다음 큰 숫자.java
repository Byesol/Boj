class Solution {
    public int solution(int n) {
        // 1. 기준이 되는 n의 1의 개수를 미리 구합니다.
        int targetBitCount = Integer.bitCount(n);
        
        // 2. n보다 큰 수부터 하나씩 늘려가며 확인합니다.
        int nextNumber = n + 1;
        
        while (true) {
            // 3. 현재 숫자의 1의 개수가 n과 같다면 정답입니다.
            if (Integer.bitCount(nextNumber) == targetBitCount) {
                return nextNumber;
            }
            nextNumber++;
        }
    }
}