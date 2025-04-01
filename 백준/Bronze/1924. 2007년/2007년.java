import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] split = br.readLine().split(" ");
        int month = Integer.parseInt(split[0]);
        int day = Integer.parseInt(split[1]);

        LocalDate localDate = LocalDate.of(2007, month, day);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        String output = dayOfWeek.name();
        String substring = output.substring(0, 3);

        System.out.println(substring.toUpperCase());

    }
}