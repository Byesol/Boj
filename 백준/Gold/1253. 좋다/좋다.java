import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] a =new int[n];
        for(int i=0;i<n;i++){

            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int answer=0;

        for(int i=0;i<n;i++) {
            int sum = a[i];
            int start = 0;
            int end = n-1;

            while(start!=end) {
                if (start == i) { // 자기 자신을 제외
                    start++;
                    continue;
                }
                if (end == i) { // 자기 자신을 제외
                    end--;
                    continue;
                }
                int is_sum = a[start] + a[end];

                if (sum < is_sum) {
                    end--;

                } else if (sum > is_sum) {
                    start++;

                }
                else{
                    answer++;
                    break;

                }
            }

        }
        sb.append(answer);
        System.out.print(answer);




        /*
        n받기
        n개만큼 숫자들 입력받기

        1. n개의 수 정렬
        2. n개의 수들에서 좋은 수 찾기..? how?
        3.

        9
        123456789
         a
           a

        1번 : 각각의 수들 n개에 대해 두개의 수로 할수있는지 탐색한다.

        n번 반복 각각의 수에 대해 나머지 수로 될 수 있는가
        for n
            f
        \
    

         */
    }
}