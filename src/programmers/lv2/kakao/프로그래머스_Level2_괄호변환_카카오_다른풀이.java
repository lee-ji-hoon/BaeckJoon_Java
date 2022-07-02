package programmers.lv2.kakao;

import java.util.Stack;

class 프로그래머스_Level2_괄호변환_카카오_다른풀이 {
    public String solution(String p) {
        return check(p);
    }

    public String check(String p){
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        if(p.length() == 0)
            return "";
        // 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        Stack<Character> stack = new Stack<>();
        int i;
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
        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        if(proper(u)){
            //  3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            return u+=check(v);
        }
        // 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
        else {
            StringBuilder incorrect = new StringBuilder();
            //  4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
            incorrect.append("(");
            //  4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            incorrect.append(check(v));
            //  4-3. ')'를 다시 붙입니다.
            incorrect.append(")");
            //  4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            u = u.substring(1, u.length()-1);

            for(int j = 0; j < u.length(); j++){
                if(u.charAt(j) == '(')
                    incorrect.append(')');
                else
                    incorrect.append('(');
            }
            //  4-5. 생성된 문자열을 반환합니다.
            return incorrect.toString();
        }
    }
    public boolean proper(String str){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char cur = str.charAt(i);
            if(cur == '(')
                stack.push(cur);
            else {
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }

        return true;
    }
    public static void main(String[] args) {
        프로그래머스_Level2_괄호변환_카카오_다른풀이 s = new 프로그래머스_Level2_괄호변환_카카오_다른풀이();
        s.solution(")(");
    }
}
