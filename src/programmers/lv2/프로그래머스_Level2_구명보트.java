package programmers.lv2;

import java.util.Arrays;

class 프로그래머스_Level2_구명보트 {
    // 시간 초과
    /*public int solution(int[] people, int limit) {
        int answer = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int weight : people) list.add(weight);
        // 1. 정렬
        Collections.sort(list);

        int count = 0;
        // 2. 0 ~ people.length 까지 합하면서 무게가 초과하면 sum값 초기화하고 answer + 1
        while(!list.isEmpty()){
            boolean flag = false;
            int temp = list.remove(0);
            int size = list.size();
            for(int i = size - 1; i >= count; i--){
                if(temp + list.get(i) <= limit) {
                    list.remove(i);
                    answer++;
                    flag = true;
                    break;
                }
            }
            if(!flag)
                answer++;
        }

        return answer;
    }*/

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int index = 0;

        for (int i = people.length - 1; i >= index; i--) {
            if (people[i] + people[index] <= limit) {
                index++;
            }
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
        프로그래머스_Level2_구명보트 s = new 프로그래머스_Level2_구명보트();
        int[] arr = {70, 50, 80, 50};
        s.solution(arr, 100);
    }
}
