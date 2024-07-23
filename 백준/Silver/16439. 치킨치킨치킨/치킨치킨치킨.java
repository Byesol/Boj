import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuffer sb = new StringBuffer();
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int max=0;

        int[][] menuSum = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine()," ");

            for (int j = 0; j < m; j++) {
                menuSum[i][j] += Integer.parseInt(st.nextToken());

            }
        }
        for(int i=0;i<m-2;i++){
            for(int j=0;j<m-1;j++){
                for(int k=0;k<m;k++){
                    int sum=0;
                    for(int l=0; l<n;l++){
                        int rmax=menuSum[l][i];
                        if(menuSum[l][j]>rmax){
                            rmax= menuSum[l][j];
                        }
                        if(menuSum[l][k]>rmax){
                            rmax= menuSum[l][k];
                        }
                        sum +=rmax;
                    }
                    if(sum>max){
                        max=sum;
                    }

                }
            }

        }

        System.out.print(max);




    }
}