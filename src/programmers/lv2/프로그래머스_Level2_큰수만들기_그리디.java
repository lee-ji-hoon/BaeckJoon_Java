package programmers.lv2;

class 프로그래머스_Level2_큰수만들기_그리디 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int size = number.length() - k;

        for(int i = 0; i < size; i++) {
            int max = 0;
            for(int j = index; j <= k + i; j++) {
                int tempNumber = number.charAt(j) - '0';
                if(max < tempNumber) {
                    max = tempNumber;
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
