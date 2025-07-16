import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] P = new int[n];
        Integer[] indices = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            indices[i] = i;
        }

        Arrays.sort(indices, (i, j) -> {
            if (A[i] != A[j]) return Integer.compare(A[i], A[j]);
            return Integer.compare(i, j);
        });

        for (int rank = 0; rank < n; rank++) {
            P[indices[rank]] = rank;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(P[i]).append(" ");
        }
        System.out.println(sb);
    }
}

