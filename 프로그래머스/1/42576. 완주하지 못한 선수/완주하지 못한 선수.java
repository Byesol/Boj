import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String,Integer> count = new HashMap<>();
        for(String c:participant){
            count.put(c,count.getOrDefault(c,0)+1);
        }
        for(String c:completion){
            if(count.containsKey(c)){
                count.put(c,count.get(c)-1);
            }
        }
        for(String key: count.keySet()){
            if(count.get(key)>=1){
                return key;
            }
        }
        
        return answer;
    }
}