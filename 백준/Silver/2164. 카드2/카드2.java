import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int n = Integer.parseInt(input);
        Queue<Integer> cards = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            cards.add(i);
        }
        int order = 0;
        while (cards.size() > 1) {
            order++;
            if (order % 2 != 0) {
                cards.remove();
            } else {
                Integer remove = cards.remove();
                cards.add(remove);
            }
        }
        int last = cards.peek();
        sb.append(last);
        System.out.print(last);
        br.close();
    }
}
