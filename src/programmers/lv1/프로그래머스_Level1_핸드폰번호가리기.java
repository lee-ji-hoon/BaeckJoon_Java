package programmers.lv1;

public class 프로그래머스_Level1_핸드폰번호가리기 {
    public String solution(String phone_number) {
        return phone_number.substring(0, phone_number.length() - 4).replaceAll("[0-9]", "*")
                +phone_number.substring(phone_number.length() - 4);
    }
    public static void main(String[] args) {
        프로그래머스_Level1_핸드폰번호가리기 s = new 프로그래머스_Level1_핸드폰번호가리기();
        s.solution("0123124124124");
    }
}
