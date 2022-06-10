package programmers.lv1;

class 프로그래머스_Level1_2016년 {
    public String solution(int a, int b) {
        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] maxDate = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int allDate = 0;

        for(int i = 0; i < a - 1; i++) allDate += maxDate[i];

        allDate += (b-1);
        return day[allDate % 7];
    }
}
