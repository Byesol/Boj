import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] mSplit = str.split("-");

        int length = mSplit.length;
        int result =0;
        int isMinus =1;
        for(int j=0;j<length;j++){
            if(j%2 == 1 ){
                isMinus = -1;
            }
            String[] pSplit = mSplit[j].split("\\+");
            int pResult =0;
            for(int i=0;i<pSplit.length;i++){
                pResult += Integer.parseInt(pSplit[i]);
            }
            result += pResult*isMinus;


        }
        System.out.print(result);


    }
}
