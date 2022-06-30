package programmers.lv3;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



class 프로그래머스_Level3_베스트앨범_해시 {
    static class Song implements Comparable<Song>{
        int id;
        int play;

        public Song(int id, int play){
            this.id = id;
            this.play = play;
        }

        @Override
        public int compareTo(Song o){
            return Integer.compare(o.play, this.play);
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answerArr = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        Map<String, ArrayList<Song>> playMap = new HashMap<>();

        for(int i = 0; i < genres.length; i++){
            String genre = genres[i];
            map.put(genre, map.getOrDefault(genre, 0) + plays[i]);
            ArrayList<Song> arr = playMap.getOrDefault(genre, new ArrayList<Song>());
            arr.add(new Song(i, plays[i]));
            playMap.put(genre, arr);
        }

        // 정렬 후 많이 재생된 순으로 뽑아내기
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));

        for(Map.Entry<String, Integer> entry : entryList){
            String genre = entry.getKey();
            ArrayList<Song> song = playMap.get(genre);
            Collections.sort(song);

            int size = song.size();
            if(size > 2){
                for(int i = 0; i < 2; i++){
                    answerArr.add(song.get(i).id);
                }
            } else{
                for (Song value : song) {
                    answerArr.add(value.id);
                }
            }
        }

        int size = answerArr.size();
        int[] answer = new int[size];
        System.out.println(answerArr);
        for(int i = 0; i < size; i++)
            answer[i] = answerArr.get(i);
        return answer;
    }

    // print(solution(['A', 'A', 'B'], [600, 500, 300]) == [0, 1, 2])
    // print(solution(['A', 'B', 'A'], [600, 500, 600]) == [0, 2, 1])
    // print(solution(['A', 'B', 'A'], [600, 500, 700]) == [2, 0, 1])
    // print(solution(['A', 'A', 'A'], [600, 500, 700]) == [2, 0])
    // print(solution(['A', 'A', 'A'], [3, 2, 1]) == [0, 1])
    // print(solution(['classic', 'pop', 'classic', 'classic', 'pop'], [500, 600, 150, 800, 2500]) == [4, 1, 3, 0])
    // print(solution(['classic'], [2500]) == [0])
    // print(solution(['A', 'B', 'C'], [1, 2, 3]) == [2, 1, 0])
    // print(solution(['A', 'B', 'C', 'D'], [1, 2, 3, 1]) == [2, 1, 0, 3])
    // print(solution(['A', 'A', 'B', 'A'], [2, 2, 2, 3]) == [3, 0, 2])
    // print(solution(['A', 'A', 'B', 'A'], [5, 5, 6, 5]) == [0, 1, 2])
    // print(solution(['A', 'A', 'B', 'A', 'B', 'B'], [5, 5, 6, 5, 7, 7]) == [4, 5, 0, 1])

}