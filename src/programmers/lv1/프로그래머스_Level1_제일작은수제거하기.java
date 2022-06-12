package programmers.lv1;

class 프로그래머스_Level1_제일작은수제거하기 {
    public int[] solution(int[] arr) {
        if(arr.length == 1) {
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[arr.length - 1];

        int min = arr[0];
        int minIdx = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min) min = arr[i];
        }

        int count = 0;

        for (int j : arr) {
            if (min == j) continue;
            answer[count++] = j;
        }
        return answer;
    }
}
