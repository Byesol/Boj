import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input= br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] entry= br.readLine().split(" ");
            String site = entry[0];
            String password= entry[1];
            map.put(site, password);

        }
        for (int i = 0; i < m; i++) {
            String target = br.readLine();
            sb.append(map.get(target)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
