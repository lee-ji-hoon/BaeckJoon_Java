package inflearn.review.step4;

import java.util.Scanner;
import java.util.Arrays;

public class Step4_2_아나그램 {
    public String solution(String str1, String str2){
        String answer = "YES";
        char[] toStr1 = str1.toCharArray();
        char[] toStr2 = str2.toCharArray();
        Arrays.sort(toStr1);
        Arrays.sort(toStr2);

        for(int i = 0; i < str1.length(); i++)
            if(toStr1[i] != toStr2[i])
                return "NO";

        return answer;
    }

    public static void main(String[] args){
        Step4_2_아나그램 T = new Step4_2_아나그램();
        Scanner sc = new Scanner(System.in);

        String str1 = sc.next();
        String str2 = sc.next();

        System.out.print(T.solution(str1, str2));
    }
}
