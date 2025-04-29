import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        String[] split = s.split(" ");
        int a = Integer.parseInt(split[0]);
        int b = Integer.parseInt(split[1]);
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < a; i++) {
            String input = br.readLine();
            map.put(input, map.getOrDefault(input, 0) + 1);
        }
        for (int i = 0; i < b; i++) {
            String input = br.readLine();
            if (map.containsKey(input)) {
                count++;
                list.add(input);
            }
        }
        sb.append(count).append("\n");
        Collections.sort(list);
        list.forEach((string) -> sb.append(string).append("\n"));
        System.out.print(sb);
    }
}