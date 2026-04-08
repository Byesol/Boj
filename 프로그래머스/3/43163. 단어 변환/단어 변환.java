import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        
        int n = words.length;
        int[] count = new int[n];
        
        // hit
        // hot, 
        
        for(int i=0;i<n;i++){
            String next =  words[i];
            // 갈 수 있는지 여부
            if(isNear(begin, next)){
                //방문 여부
                if(count[i]==0){
                    count[i] = 1;
                    queue.offer(i);
                }
            }
                
        }
        // queue: 0 - hot
        // hot 
        // vIndex : 0
        // vString : hot
        // lot
        // bfs
        while(!queue.isEmpty()){
            int vIndex = queue.poll();
            String vString = words[vIndex];
            //도달여부
            if(vString.equals(target)){
                return count[vIndex];
            }
            
            for(int i=0;i<n;i++){
                String next =  words[i];
                // 갈 수 있는지 여부
                if(isNear(vString, next)){
                    //방문 여부
                    if(count[i]==0){
                        count[i] = count[vIndex]+1;
                        queue.offer(i);
                    }
                }
                
            }
        }
        return 0;
        
    }
    
    public boolean isNear(String a, String b){
        int n = a.length();
        
        int count = 0;
        for(int i =0;i<n;i++){
            if(a.charAt(i)!= b.charAt(i)){
                count++;
            }
        }
        if(count<=1){
            return true;
        }
        return false;
    }
}