package inflearn.review.step1;

import java.util.Scanner;

public class Step1_5_특정문자뒤집기 {
    public String solution(String str){
        char[] arr = str.toCharArray();
        int length  = str.length();
        int lt = 0;
        int rt = length - 1;

        while(rt > lt){
            if(!Character.isAlphabetic(arr[lt]))
                lt++;
            else if(!Character.isAlphabetic(arr[rt]))
                rt--;
            else {
                char temp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = temp;
                lt++;
                rt--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : arr)
            sb.append(c);

        String answer = sb.toString();
        return answer;
    }

    public static void main(String[] args){
        Step1_5_특정문자뒤집기 T = new Step1_5_특정문자뒤집기();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(T.solution(str));
    }
}