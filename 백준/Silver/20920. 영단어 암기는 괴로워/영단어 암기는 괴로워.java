import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuffer sb= new StringBuffer();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

       HashMap<String,Integer> map = new HashMap<>();
       List<String> list = new ArrayList<String>();
        for(int i=0;i<n;i++) {
            String word = br.readLine();
            if(word.length()>=m){
                if(map.containsKey(word)){
                    int oldvalue = map.get(word);
                    map.put(word,oldvalue+1);
                    continue;
                }
                map.put(word,0);
                list.add(word);
            }
        }

        Collections.sort(list, new Comparator<String>(){
            public int compare(String str1, String str2){
                if(map.get(str1) != map.get(str2)){
                    return Integer.compare(map.get(str2),map.get(str1));
                }
                if(str1.length()!=str2.length()){
                    return  Integer.compare(str2.length(),str1.length());
                }
                return str1.compareTo(str2);
            }

        });
        for(String each: list){
            sb.append(each);
            sb.append("\n");
        }
        System.out.print(sb);







    }
}