package inflearn.review.step1;

import java.util.Scanner;

public class Step1_4_단어뒤집기 {
    public String[] solution(String[] arr){
        String[] answer = new String[arr.length];

        int count = 0;
        for(String str : arr){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < str.length(); i++)
                sb.append(str.charAt(i));

            answer[count] = sb.reverse().toString();
            count++;
        }

        return answer;
    }
    public static void main(String[] args){
        Step1_4_단어뒤집기 T = new Step1_4_단어뒤집기();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String[] arr = new String[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.next();

        String[] solution = T.solution(arr);
        for (String s : solution)
            System.out.println(s);
    }
}