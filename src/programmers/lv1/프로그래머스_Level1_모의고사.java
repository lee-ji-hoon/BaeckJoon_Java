package programmers.lv1;

class 프로그래머스_Level1_모의고사 {
    public int[] solution(int[] answers) {

        // 1번 수포자
        int[] hellMath1 = {1, 2, 3, 4, 5};
        // 2번 수포자
        int[] hellMath2 = {2, 1, 2, 3, 2, 4, 2, 5};
        // 3번 수포자
        int[] hellMath3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        // 맞춘 문제 합 저장
        int[] answerCount = new int[3];

        for(int i = 0; i < answers.length; i++) {
            // 간 수포자들 마다 반복되는 수가 다르므로 각각의 값이 필요
            // 1번 수포자는 5개씩 반복
            int five = i % 5;
            // 2번 수포자는 8개씩 반복
            int eight = i % 8;
            // 3번 수포자는 10개씩 반복
            int ten = i % 10;

            if(hellMath1[five] == answers[i]) answerCount[0] += 1;
            if(hellMath2[eight] == answers[i]) answerCount[1] += 1;
            if(hellMath3[ten] == answers[i]) answerCount[2] += 1;
        }

        // 최대값 구하기
        int max = answerCount[0];
        for(int i = 1; i < 3; i++){
            if(max < answerCount[i]) {
                max = answerCount[i];
            }
        }

        // 가장 많이 맞춘 사람 체크
        int[] tempArr = new int[3];
        // answer 배열 길이 구하기
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if(max == answerCount[i]) {
                tempArr[i] = i + 1;
                count++;
            }
        }

        // 정답 구하기
        int[] answer = new int[count];
        int answerIndex = 0;
        for (int i = 0; i < 3; i++) {
            if(tempArr[i]!=0) {
                answer[answerIndex] = tempArr[i];
                answerIndex++;
            }
        }
        return answer;
    }
}