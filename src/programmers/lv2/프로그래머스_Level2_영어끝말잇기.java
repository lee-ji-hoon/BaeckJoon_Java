package programmers.lv2;

import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

class 프로그래머스_Level2_영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < words.length; i++){
            String now = words[i];
            // 이미 있는 단어
            if(!set.add(now)){
                System.out.println("이미 있는 단어 : " + i);
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            // 이전 단어의 끝 글자 안갖고 온 경우
            if(!stack.isEmpty()){
                String prev = stack.peek();
                if (prev.charAt(prev.length() -1) != now.charAt(0)){
                    System.out.println("이전 단어 끝 글자 안갖고 온 경우 : " + i);
                    answer[0] = i % n + 1;
                    answer[1] = i / n + 1;
                    break;
                }
            }
            stack.push(now);
            // 1글자 입력 경우
            if(words[i].length() == 1){
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
        }

        return answer;
    }
}
