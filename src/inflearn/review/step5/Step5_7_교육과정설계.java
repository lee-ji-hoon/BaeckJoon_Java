package inflearn.review.step5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Step5_7_교육과정설계 {
    public String solution(String essential, String my){
        String answer = "YES";
        Queue<Character> essential_s = new LinkedList<>();
        Queue<Character> my_s = new LinkedList<>();

        for(int i = 0; i < essential.length(); i++){
            essential_s.add(essential.charAt(i));
        }

        for(int i = 0; i < my.length(); i++){
            my_s.add(my.charAt(i));
        }

        while(!essential_s.isEmpty() && !my_s.isEmpty()){
            char es = essential_s.peek();
            char m = my_s.peek();
            if(es == m)
                essential_s.remove();

            my_s.remove();
        }
        if(!essential_s.isEmpty())
            answer = "NO";
        return answer;
    }
    public static void main(String[] args){
        Step5_7_교육과정설계 T = new Step5_7_교육과정설계();
        Scanner sc = new Scanner(System.in);

        String essential = sc.next();
        String my = sc.next();

        System.out.print(T.solution(essential, my));
    }
}