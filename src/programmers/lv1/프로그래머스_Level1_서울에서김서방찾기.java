package programmers.lv1;

class 프로그래머스_Level1_서울에서김서방찾기 {
    public String solution(String[] seoul) {
        int count = 0;
        for(String name : seoul){
            if(name.equals("Kim")) break;
            count++;
        }

        String answer = "김서방은 " + count + "에 있다";
        return answer;
    }
}
