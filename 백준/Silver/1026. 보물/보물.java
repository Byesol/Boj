
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n  = Integer.parseInt(br.readLine());
        List<Integer> aList = makeList(br, n);
        List<Integer> bList =makeList(br, n);
        Collections.sort(aList);
        bList.sort(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i <n ; i++) {
            int eachResult = aList.get(i) * bList.get(i);
            sum += eachResult;
        }
        System.out.println(sum);
    }

    public static List<Integer> makeList(BufferedReader br,int n) throws IOException {
        List<Integer>  numbers = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i <n ; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        return numbers;
    }
}

