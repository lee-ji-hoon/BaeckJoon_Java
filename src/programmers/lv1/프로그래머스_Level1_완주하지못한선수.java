package programmers.lv1;

import java.util.Arrays;

public class 프로그래머스_Level1_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < participant.length; i++){
            if(i == participant.length-1) return participant[participant.length-1];
            if(!participant[i].equals(completion[i])) return participant[i];
        }
        return null;
    }
}