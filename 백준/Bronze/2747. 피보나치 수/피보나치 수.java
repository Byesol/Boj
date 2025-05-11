import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] array = new int[46];
        //재귀,분할 정복으로도 풀 수 있지만.. 공간 vs 시간 트레이드 오프
        // 뭐가 더 좋을까
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        int n = Integer.parseInt(br.readLine());
        for (int i = 2; i < n + 1; i++) {
            array[i] = array[i - 1] + array[i - 2];
        }
        sb.append(array[n]);
        //첫번째가 0이 아니네
        System.out.print(sb);

        br.close();
    }
}
