package programmers.lv2.kakao;


import java.util.*;

class 프로그래머스_Level2_수식최대화_카카오 {
    static ArrayList<String> operatorArr = new ArrayList<>();
    static ArrayList<String> numbers = new ArrayList<>();
    public long solution(String expression) {
        long answer = 0;
        // 숫자를 제외한 연산자 찾기
        String operator = findOperator(expression);

        int operatorSize = operator.length();

        // 모든 경우의 수 찾기
        boolean[] visited = new boolean[operatorSize];
        Stack<Character> stack = new Stack<>();
        findCombination(visited,  operatorSize, operator, stack);

        for (String s : operatorArr) {
            answer = Math.max(answer, solve(s));
        }
        System.out.println(answer);
        return answer;
    }

    private long solve(String priority) {
        ArrayList<String> numbersClone = new ArrayList<>(numbers);
        for (int i = 0; i < priority.length(); i++) {
            String oper = String.valueOf(priority.charAt(i));
            for (int j = 0; j < numbersClone.size(); j++) {
                if(numbersClone.get(j).equals(oper)){
                    long prev = Long.parseLong(numbersClone.get(j - 1));
                    long next = Long.parseLong(numbersClone.get(j + 1));
                    long temp = calc(prev, next, oper);

                    numbersClone.remove(j-1);
                    numbersClone.remove(j-1);
                    numbersClone.remove(j-1);
                    numbersClone.add(j-1, String.valueOf(temp));
                    j-=2;
                }
            }
        }
        return Math.abs(Long.parseLong(numbersClone.get(0)));
    }

    private long calc(long prev, long next, String oper) {
        switch (oper){
            case "+" :
                return prev + next;
            case "-" :
                return prev - next;
            default :
                return prev * next;
        }
    }

    public void findCombination(boolean[] visited, int count, String operator, Stack<Character> stack){
        if(stack.size() == count){
            StringBuilder sb = new StringBuilder();
            for (Character character : stack)
                sb.append(character);
            operatorArr.add(sb.toString());
        } else {
            for (int i = 0; i < count; i++) {
                if(!visited[i]) {
                    stack.push(operator.charAt(i));
                    visited[i] = true;
                    findCombination(visited, count, operator, stack);
                    stack.pop();
                    visited[i] = false;
                }
            }
        }
    }



    public String findOperator(String str){
        Set<Character> set = new HashSet<>();

        char[] toChar = str.toCharArray();
        StringBuilder digit = new StringBuilder();
        for(char ch : toChar) {
            if (!Character.isDigit(ch)) {
                numbers.add(digit.toString());
                set.add(ch);
                numbers.add(String.valueOf(ch));
                digit.setLength(0);
            } else
                digit.append(ch);
        }

        if(digit.length() != 0)
            numbers.add(digit.toString());


        StringBuilder sb = new StringBuilder();
        for(Character ch : set)
            sb.append(ch);

        return sb.toString();
    }

    public static void main(String[] args) {
        프로그래머스_Level2_수식최대화_카카오 s = new 프로그래머스_Level2_수식최대화_카카오();
        s.solution("100-200*300-500+20");

    }
}