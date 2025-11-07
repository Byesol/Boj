import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        // String의 startWith 함수를 사용하면 알 수 있다.
        // 모든 얘들을 일일이 다 다른 얘에 startwith을 할 것인가?
        // 길이가 짧은 얘들을 길이가 긴 얘들에 하면 더 좋다.
        // 모든 얘들의 길이를 구한다쳐도 결국 이중 for문 아닌가?
        Arrays.sort(phone_book);
        for(int i = 0; i<phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
            
        }
        
        return true;
        
    }
}