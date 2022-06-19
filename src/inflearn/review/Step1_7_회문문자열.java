package inflearn.review;

import java.util.Scanner;

public class Step1_7_회문문자열 {
    public String solution(String str){
        str = str.toUpperCase();

        int lt = 0;
        int rt = str.length() - 1;

        while(lt < rt){
            if(str.charAt(lt) != str.charAt(rt))
                return "NO";
            lt++;
            rt--;
        }
        return "YES";
    }

    public static void main(String[] args){
        Step1_7_회문문자열 T = new Step1_7_회문문자열();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.print(T.solution(str));
    }
}