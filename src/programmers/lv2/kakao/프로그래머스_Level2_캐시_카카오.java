package programmers.lv2.kakao;

import java.util.ArrayList;

class 프로그래머스_Level2_캐시_카카오 {
    static ArrayList<String> citiesList = new ArrayList<>();
    public void swap(int idx){
        for(int i = idx; i > 0; i--)
            citiesList.set(i, citiesList.get(i-1));
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0)
            return cities.length * 5;

        String[] cache = new String[cacheSize];
        for(String city : cities){
            boolean flag = false;
            city = city.toUpperCase();
            for(int i = 0; i < cache.length; i++){
                // hit
                if(cache[i] != null && cache[i].equals(city)){
                    System.arraycopy(cache, 0, cache, 1, i);
                    answer += 1;
                    flag = true;
                    break;
                }
                // 0까지 도달했을 경우 hit된게 없다는 의미
                else if(cache[i] == null){
                    System.arraycopy(cache, 0, cache, 1, i);
                    answer += 5;
                    flag = true;
                    break;
                }
            }
            // 끝까지 돌았지만 hit한 것이 없을 경우 -> miss
            if(!flag){
                answer += 5;
                System.arraycopy(cache, 0, cache, 1, cacheSize - 1);
            }
            cache[0] = city;
        }

        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_캐시_카카오 s = new 프로그래머스_Level2_캐시_카카오();
        String[] city = {"Jeju", "Pangyo", "NewYork", "newyork"};
        int solution = s.solution(2, city);
        System.out.println("solution = " + solution);
    }
}
