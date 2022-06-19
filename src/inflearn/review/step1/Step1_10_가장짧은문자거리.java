package inflearn.review.step1;

import java.util.Scanner;

public class Step1_10_가장짧은문자거리 {
    public int[] solution(String str, String find){
        int[] answer = new int[str.length()];

        for(int i = 0; i < str.length(); i++){
            char standard = str.charAt(i);
            if(String.valueOf(standard).equals(find)){
                answer[i] = 0;
                continue;
            }

            int left = checkLeft(str, find, i);
            int right = checkRight(str, find, i);

            int findIdx = 0;
            if(left == -1)
                findIdx = right - i;
            else if(right == -1)
                findIdx = i - left;
            else
                findIdx = Math.min(i - left, right - i);
            answer[i] = findIdx;

        }
        return answer;
    }

    public int checkLeft(String str, String find, int i){
        while(i >= 0){
            char standard = str.charAt(i);
            if(String.valueOf(standard).equals(find)){
                return i;
            }
            i--;
        }
        return -1;
    }

    public int checkRight(String str, String find, int i){
        while(i < str.length()){
            char standard = str.charAt(i);
            if(String.valueOf(standard).equals(find)){
                return i;
            }
            i++;
        }
        return -1;
    }
    public static void main(String[] args){
        Step1_10_가장짧은문자거리 T = new Step1_10_가장짧은문자거리();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        String find = sc.next();

        int[] arr = T.solution(str, find);

        for(int num : arr)
            System.out.print(num + " ");
    }
}