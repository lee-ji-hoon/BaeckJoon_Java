package programmers.lv1;

class 프로그래머스_Level1_숫자문자열과영단어 {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder answer_sb = new StringBuilder();

        for (int i = 0; i < s.length() + 1; i++) {
            switch (sb.toString()) {
                case "zero" : {
                    answer_sb.append(0);
                    sb.delete(0, sb.length());
                    break;
                }
                case "one": {
                    answer_sb.append(1);
                    sb.delete(0, sb.length());
                    break;
                }
                case "two": {
                    answer_sb.append(2);
                    sb.delete(0, sb.length());
                    break;
                }
                case "three": {
                    answer_sb.append(3);
                    sb.delete(0, sb.length());
                    break;
                }
                case "four": {
                    answer_sb.append(4);
                    sb.delete(0, sb.length());
                    break;
                }
                case "five": {
                    answer_sb.append(5);
                    sb.delete(0, sb.length());
                    break;
                }
                case "six": {
                    answer_sb.append(6);
                    sb.delete(0, sb.length());
                    break;
                }
                case "seven": {
                    answer_sb.append(7);
                    sb.delete(0, sb.length());
                    break;
                }
                case "eight": {
                    answer_sb.append(8);
                    sb.delete(0, sb.length());
                    break;
                }
                case "nine": {
                    answer_sb.append(9);
                    sb.delete(0, sb.length());
                    break;
                }
            }
            if (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                answer_sb.append(s.charAt(i));
                continue;
            }
            if(i < s.length()) sb.append(s.charAt(i));
        }
        answer = Integer.parseInt(String.valueOf(answer_sb));
        System.out.println(answer);
        return answer;
    }

    public int solution2(String s) {
        int answer = 0;

        String[] replaceString = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i=0; i<replaceString.length; i++){
            s = s.replaceAll(replaceString[i], String.valueOf(i));
        }
        answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level1_숫자문자열과영단어 s = new 프로그래머스_Level1_숫자문자열과영단어();
        s.solution("23four5six7");
    }
}
