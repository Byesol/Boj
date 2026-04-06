import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
  
        // 1. N 입력 (보통 첫 줄에 하나만 존재)
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        // 2. N개의 배열 데이터 입력 (둘째 줄 새로 읽기)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 정렬 필수
  
        // 3. M 입력 (셋째 줄 새로 읽기)
        int m = Integer.parseInt(br.readLine());
        
        // 4. M개의 찾을 데이터 입력 (넷째 줄 새로 읽기)
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int find = Integer.parseInt(st.nextToken());
            
            int lowerBound = lowerBound(arr, find);
            int upperBound = upperBound(arr, find);

            sb.append(upperBound - lowerBound).append(" ");
        }
        System.out.println(sb);
    }
    
    // Lower Bound: 하한선 (정상 작동하므로 그대로 둠)
    public static int lowerBound(int[] array, int find){
        int left = 0;
        int right = array.length;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(array[mid] >= find){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
        
    // Upper Bound: 상한선 (수정됨)
    public static int upperBound(int[] array, int find){
        int left = 0;
        int right = array.length;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(array[mid] > find){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}