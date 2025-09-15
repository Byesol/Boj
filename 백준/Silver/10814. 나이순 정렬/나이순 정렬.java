import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            list.add(new Member(age, name));
        }

        list.sort(Comparator.comparingInt(m -> m.age));

        for (Member m : list) {
            sb.append(m.age).append(' ').append(m.name).append('\n');
        }

        System.out.print(sb);
    }
        static class Member {
        int age;
        String name;
        Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
