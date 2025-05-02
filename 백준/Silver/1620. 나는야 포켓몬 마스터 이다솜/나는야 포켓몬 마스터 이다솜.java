import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        Map<Integer, String> map1 = new HashMap<>();
        Map<String,Integer > map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map1.put(i + 1,s);
            map2.put(s,i + 1);
        }
        for (int i = 0; i < m; i++) {
            String input= br.readLine();
            try {
                int num = Integer.parseInt(input);
                sb.append(map1.get(num)).append("\n");
            } catch (NumberFormatException e) {
                sb.append(map2.get(input)+"\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
