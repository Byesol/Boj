import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int D[][] = new int[n+1][n+1];
        //지금의 배열은 0부터시작
        for(int i = 1;i<n+1;i++){// 각각의 줄
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++){ // 각각의 숫
                D[i][j] = D[i-1][j]+D[i][j-1]-D[i-1][j-1]+Integer.parseInt(st2.nextToken()); // 실질 좌표는 -1
                //첫째줄에 1234
            }
        }

        for(int i=0;i<m;i++){
            StringTokenizer st3 = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st3.nextToken());
            int y1 = Integer.parseInt(st3.nextToken());
            int x2 = Integer.parseInt(st3.nextToken());
            int y2 = Integer.parseInt(st3.nextToken());
            int sum = D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1];
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}