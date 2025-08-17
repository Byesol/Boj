
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> worker = new HashSet<String>(); 

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            String name = st.nextToken(); 	
            String status = st.nextToken();	
            worker.add(name); 			
            if (status.equals("leave")) { 	
                worker.remove(name); 		
            }
        }
        String[] ary = worker.toArray(new String[worker.size()]); 
        Arrays.sort(ary, Collections.reverseOrder()); 		

        for (String s : ary) { 					
            System.out.println(s);
        }
    }
}