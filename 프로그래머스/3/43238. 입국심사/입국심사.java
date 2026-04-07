class Solution {
    public long solution(int n, int[] times) {
        
        int length = times.length;
        
        long min = Long.MAX_VALUE;
        for(int i = 0;i<length;i++){
            min = Math.min(min,times[i]);
        }
        long left = 1; 
        long right = n*min;
        while(left<right){
            long people = 0;
            long mid = left +(right-left)/2;
            for(int i = 0;i<length;i++){
                 people += mid / times[i];
            }
            if(people>=n){
                right= mid;
            }
            else{
                left= mid+1;
            }
            
        }
        
        return left;
    }
}