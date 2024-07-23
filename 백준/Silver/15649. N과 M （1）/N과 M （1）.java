import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 방문 여부를 저장하는 배열
    static int[] visit;
    // 현재 수열을 저장하는 배열
    static int[] arr;
    // 결과를 저장할 StringBuffer
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력을 공백으로 구분하여 읽기
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // N: 1부터 N까지의 자연수, M: 선택할 수열의 길이
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 방문 여부를 저장하는 배열 초기화
        visit = new int[n];
        // 현재 수열을 저장하는 배열 초기화
        arr = new int[m];

        // 깊이 우선 탐색 시작
        dfs(n, m, 0);

        // 결과 출력
        System.out.print(sb.toString());
    }

    // 깊이 우선 탐색 함수
    public static void dfs(int n, int m, int depth) {
        // 현재 깊이가 M이면 수열을 완성한 것이므로 출력
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1부터 N까지의 숫자를 순회
        for (int i = 0; i < n; i++) { //n개의 숫자 중 M개의 숫자를 모두 골라야 하므로 n은 다 순회해야함
            // 현재 숫자를 방문하지 않았다면
            if (visit[i] == 0) {
                visit[i] = 1;  // 방문 표시
                arr[depth] = i + 1;  // 현재 깊이에 해당 숫자 저장
                dfs(n, m, depth + 1);  // 다음 깊이로 재귀 호출
                visit[i] = 0;  // 재귀 호출이 끝나면 방문 표시 해제
            }
        }
    }
}
