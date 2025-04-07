import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <n ; i++) {
            String input = br.readLine();
            String[] split = input.split(" ");
            if (split[0].equals("add")) {
                set.add(Integer.parseInt(split[1]));
            }
            if (split[0].equals("check")) {

                if (set.contains(Integer.parseInt(split[1]))) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            }
            if (split[0].equals("remove")) {
                set.remove(Integer.parseInt(split[1]));
            }
            if (split[0].equals("toggle")) {
                if (set.contains(Integer.parseInt(split[1]))) {
                    set.remove(Integer.parseInt(split[1]));
                } else {
                    set.add(Integer.parseInt(split[1]));
                }
            }
            if (split[0].equals("all")) {
                set.clear();
                for (int j = 1; j < 21; j++) {
                    set.add(j);
                }
            }
            if (split[0].equals("empty")) {
                set.clear();
            }


        }
        System.out.print(sb);
        br.close();
    }

}
