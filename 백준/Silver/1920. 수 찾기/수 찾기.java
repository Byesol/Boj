import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        // 3. n이 아니라 m번만큼 반복해야 합니다.
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            // 탐색 결과를 StringBuilder에 저장
            sb.append(find(array, target)).append("\n");
        }
        
        // 최종 결과 출력
        System.out.println(sb);
    }
    // 4. 이진 탐색 로직 완성 (반복문 방식)
    static int find(int[] sortedArray, int target) {
        int left = 0;
        int right = sortedArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 중간 인덱스 계산 (오버플로우 방지)

            if (sortedArray[mid] == target) {
                return 1; // 찾았을 경우 1 반환
            } 
            else if (sortedArray[mid] > target) {
                right = mid - 1; 
            } 
            else {
                left = mid + 1;  
            }
        }

        return 0; // 끝까지 못 찾았을 경우 0 반환
    }
}