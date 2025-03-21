class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = {};
        int newNumer1 = numer1 * denom2;
        int newNumer2 = numer2* denom1;
        int newDenom = denom1*denom2;
        
        int newNumer = newNumer1+newNumer2;
        
        int cd = getCD(newNumer, newDenom);
        answer=  new int[] { newNumer/cd,newDenom /cd };
        return answer;
    }
    
    
    private int getCD(int a, int b){
        while(b!=0){
            int tmp = a%b;
            a = b;
            b= tmp;
        }
        return a;
    }
}