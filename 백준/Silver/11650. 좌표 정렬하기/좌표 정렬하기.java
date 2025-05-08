import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Position> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Position(x, y));
        }
        Collections.sort(list, new Comparator<Position>() {
            @Override
            public int compare(final Position o1, final Position o2) {
                if (o1.x.equals(o2.x)) {
                    return o1.y.compareTo(o2.y);
                } else {
                    return o1.x.compareTo(o2.x);
                }
            }
        });
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i).x).append(" ").append(list.get(i).y).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

}

class Position {
    public final Integer x;
    public final Integer y;

    Position(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
}
