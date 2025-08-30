import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        for (int i=0; i<arr.length-1; i++) {
            int num = getResult(arr[i+1], arr[i]);
            arr[i+1] = (arr[i] * arr[i+1]) / num;
            
        }
        return arr[arr.length-1];
    }

    public static int getResult(int n1, int n2) {
        if  (n1 % n2 == 0) {
            return n2;
        }
        return getResult(n2, n1%n2);
    }
}