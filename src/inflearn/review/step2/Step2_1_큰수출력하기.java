package inflearn.review.step2;

import java.util.Scanner;
import java.util.ArrayList;

public class Step2_1_큰수출력하기 {
    public ArrayList<Integer> solution(int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();

        answer.add(arr[0]);
        for(int i = 1; i < arr.length - 1; i++){
            if(arr[i] > arr[i-1])
                answer.add(arr[i]);
        }

        return answer;
    }

    public static void main(String[] args){
        Step2_1_큰수출력하기 T = new Step2_1_큰수출력하기();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> answer = T.solution(arr);
        for(int num : answer)
            System.out.print(num + " ");
    }
}
