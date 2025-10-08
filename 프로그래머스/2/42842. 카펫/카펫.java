class Solution {
    public int[] solution(int brown, int yellow) {
        // 1. 전체 카펫의 격자 수를 구합니다.
        int totalArea = brown + yellow;
        
        // 2. 가능한 세로 길이(height)로 반복문을 실행합니다.
        // 세로 길이는 최소 3 이상이어야 중앙에 노란색이 위치할 수 있습니다.
        for (int height = 3; height <= totalArea; height++) {
            
            // 3. 세로 길이가 전체 넓이의 약수일 때만 가로 길이를 계산합니다.
            if (totalArea % height == 0) {
                int width = totalArea / height;
                
                // 카펫의 가로 길이는 세로 길이보다 크거나 같다는 제약조건을 활용합니다.
                if (width < height) {
                    continue; // 더 이상 탐색할 필요가 없으므로 다음 height로 넘어갑니다.
                }
                
                // 4. 계산된 가로, 세로 길이로 노란색 격자 수를 확인합니다.
                int yellowArea = (width - 2) * (height - 2);
                
                if (yellowArea == yellow) {
                    // 5. 조건에 맞는다면 해당 width, height를 반환합니다.
                    return new int[]{width, height};
                }
            }
        }
        
        // 문제 조건상 항상 답이 존재하므로 이 코드는 실행되지 않습니다.
        // 문법적으로 return이 필요하여 추가합니다.
        return null; 
    }
}