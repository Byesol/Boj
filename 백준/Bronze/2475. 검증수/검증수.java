import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] nuimbers =   br.readLine().split(" ");
        int result =0;
        for (String nuimber : nuimbers) {
            int i = Integer.parseInt(nuimber);
            result = result+i*i;
        }
        System.out.println(result % 10);
    }
}

