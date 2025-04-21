import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());
        sb.append(factorial(n));
        System.out.print(sb);
        
    }

    private static long factorial(long n){
        if(n==0){
            return 1L;
        }
        return n*factorial(n-1);
    }
}