package programmers.lv2.kakao;
import java.util.Stack;

class 프로그래머스_Level2_괄호변환_카카오 {
    // 올바른 괄호
    private boolean isBracket(String str){
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            if(temp == '(')
                stack.push('(');
                // 닫는 괄호
            else{
                if(stack.isEmpty())
                    return false;
                stack.pop();
            }
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }

    public  String seperation(String p){
        /* 입력이 빈 문자열인 경우 빈 문자열 반환 */
        if(p.length() == 0)
            return "";

        char[] toChar = p.toCharArray();

        int open = 0;
        int close = 0;
        for(char ch : toChar){
            if(ch == '(')
                open++;
                // 닫는 괄호
            else
                close++;
            if(open == close)
                break;
        }

        String u = p.substring(0, open+close);
        String v = "";
        if((open+close) != p.length())
            v = p.substring(open+close);

        /* 문쟈열 u가 올바른 괄호 문자열이라면 문자열 v에 대해 1단계부터 다시 수행 */
        if(isBracket(u))
            return u += seperation(v); // 수행한 결과 문자열을 u에 이어 붙인 후 반환
        /* 문자열 u가 올바른 괄호 문자열이 아니라면 */
        else{
            StringBuilder temp = new StringBuilder("(");  // 빈 문자열에 첫 번째 문자로 '('를 붙임
            temp.append(seperation(v));     // 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열 이어 붙임
            temp.append(")");        // ')'를 붙임
            u = u.substring(1, u.length()-1);   // u의 첫번째와 마지막 문자 제거
            /* 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙임 */
            for(int i=0; i<u.length(); i++){
                if(u.charAt(i) =='(')
                    temp.append(')');
                else
                    temp.append('(');

            }

            return temp.toString();    // 생성된 문자열 반환
        }
    }
    public String solution(String p) {
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(isBracket(p) || p.length() == 0)
            return p;

        String answer = seperation(p);
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_괄호변환_카카오 s = new 프로그래머스_Level2_괄호변환_카카오();
        String solution = s.solution("()))((()");
        System.out.println(solution);
    }
}