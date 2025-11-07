import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        /*
        1. 일단 첫 번째로 Map - 장르, 총 길이 합 이 필요
        2. 두 번째로 Map - 장르, 번호 리스트 필요
        3. 이를 통해 장르들을 총 길이에 따라 정렬하고 
        4. 이를 통해 위에서부터 주자.
        */
        
        //장르 정렬을 위한 맵
        Map<String,Integer> map1 = new HashMap<>();
        // 각 장르별 번호를 모은 맵
        Map<String,List<Integer>> map2= new HashMap<>();
        
        for(int i = 0; i<genres.length;i++){
            String genre = genres[i];
            int play = plays[i];
            
            // 맵에 총 길이 저장하자
            map1.put(genre, map1.getOrDefault(genre,0)+play);
            // 맵에 
            if (!map2.containsKey(genre)) {
                // 없으면 새 리스트 만들어 넣기
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map2.put(genre, list);
            } else {
                // 이미 있으면 꺼내서 추가
                map2.get(genre).add(i);
            }
        }
            
        // 맵에 일단 다 저장완료

        // 장르들을 정렬하자. 총 시간에 따라
        List<String> listGenre = new ArrayList<>(map1.keySet());
        listGenre.sort((a,b)->map1.get(b)-map1.get(a));
        
        // 결과 리스트 구하기
        List<Integer> result = new ArrayList<>();
        for(String g:listGenre){
            
            List<Integer> songList = map2.get(g);
            // 장르 내 정렬: plays 내림차순 → index 오름차순
            songList.sort((a, b) -> {
                if (plays[a] != plays[b]) {
                    return plays[b] - plays[a];
                }
                return a - b;
            });

     
            int pick = Math.min(2, songList.size());
            for (int i = 0; i < pick; i++) {
                result.add(songList.get(i));
            }
        }
        return result.stream().mapToInt(i->i).toArray();
            
            
    }
}