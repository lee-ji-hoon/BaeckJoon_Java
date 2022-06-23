package programmers.lv2;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

class 프로그래머스_Level2_오픈채팅방_카카오 {
    public String[] solution(String[] record) {
        ArrayList<String> chat = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for (String value : record) {
            String[] temp = value.split(" ");

            // 들어온 경우
            if (temp[0].equals("Enter")) {
                map.put(temp[1], temp[2]);
                chat.add(temp[1] + "님이 들어왔습니다.");
                // 나간 경우
            } else if (temp[0].equals("Leave")) {
                chat.add(temp[1] + "님이 나갔습니다.");
                // 이름을 바꾼 경우
            } else {
                map.put(temp[1], temp[2]);
            }
        }
        String[] answer = new String[chat.size()];
        int logidx = 0;
        for(String str : chat){
            int idx = str.indexOf("님");
            String id = str.substring(0, idx);

            answer[logidx++] = str.replace(id, map.get(id));
        }
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_오픈채팅방_카카오 s = new 프로그래머스_Level2_오픈채팅방_카카오();
        String[] str = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        s.solution(str);
    }
}
