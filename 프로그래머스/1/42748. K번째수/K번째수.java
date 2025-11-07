import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] result = new int[n];
        int count = 0;
        
        for(int[] command:commands){
            // 각 커맨드별로 다 하나싹 차래대로 실행한다.
            int i = command[0];    
            int j = command[1];    
            int k = command[2];
             // 1번 슬라이스 구체적 실행 : 그냥 for문 돌려서
            int[] slice = new int[j-i+1];
            for(int x=i;x<=j; x++){
                slice[x-i] = array[x-1];
            }
            // 슬라이스를 구했다.
            Arrays.sort(slice);
            int returnElement = slice[k-1];
            result[count] = returnElement;
            count++;
        }
        
        // 결국 commands 숫자가 결과 크기다.
        // 각 커맨드 실행결과를 하나싹 결과에 추가한다
        // 각 커맨드 실행결과는 어떻게 구하는가?
        // 각 커맨드 배열을 순환하며 진행한다.
        
        // 각 커맨드별로 다 하나싹 차래대로 실행한다.
        // 1번 구체적 실행 : 그냥 for문 돌려서
        // 2번 구체적 실행 : Arrays.sort
        // 3번 구체적 실행 : 인덱스 직접 접근
        
        
        
        
        
        return result;
    }
}