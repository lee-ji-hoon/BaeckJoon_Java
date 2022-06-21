package inflearn.review.step4;

import java.util.Scanner;
import java.util.Arrays;

public class Step4_4_모든아나그램 {
    public int solution(String str, String find){
        int answer = 0;
        char[] strChar = find.toCharArray();
        Arrays.sort(strChar);

        String sortFind = String.valueOf(strChar);

        for(int i = 0; i <= str.length() - find.length(); i++){
            String temp = str.substring(i, i + find.length());
            char[] current = temp.toCharArray();
            Arrays.sort(current);
            String last = String.valueOf(current);
            if(sortFind.equals(last))
                answer++;
        }

        return answer;
    }
    public static void main(String[] args){
        Step4_4_모든아나그램 T = new Step4_4_모든아나그램();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String find = sc.next();

        System.out.print(T.solution(str, find));
    }
}