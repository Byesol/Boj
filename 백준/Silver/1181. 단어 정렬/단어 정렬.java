import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> strings = new HashSet<>();
        for (int i = 0; i < n; i++) {
            strings.add(br.readLine());
        }

        List<String> stringList = new ArrayList<>(strings);
        stringList.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length(); // 길이 오름차순
                }
                return s1.compareTo(s2); // 사전순
            }
        });

        for (String s : stringList) {
            System.out.println(s);
        }

        br.close();
    }
}
