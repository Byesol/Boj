import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        //중간 중간 삭제가 편하게 linkedlist
        //원형 연결 리스트..?
        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int index= 0; // 첫번째의 인덱스
        for(int i=1; i<=n;i++) {
            list.add(i);
        }
        //남아있는 청설모가 k마리보다 적을 때
        while(true) {
            if (k > list.size()) {
                sb.append(list.getFirst());
                break;
            } else {

                for (int i = 1; i < k; i++) {
                    list.remove(1);
                }
                if (list.size() >= 2) {
                    int temp = list.getFirst();
                    list.add(temp);
                    list.removeFirst();
                }

            }
        }
        System.out.print(sb);


    }
}
