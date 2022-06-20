package inflearn.review.step3;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Step3_1_두배열합치기 {
    public ArrayList<Integer> solution(Queue<Integer> arr1, Queue<Integer> arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        while(!arr1.isEmpty() && !arr2.isEmpty()){
            int num1 = arr1.peek();
            int num2 = arr2.peek();

            if(num1 > num2){
                arr2.remove();
                answer.add(num2);
            } else{
                arr1.remove();
                answer.add(num1);
            }
        }

        if(arr1.isEmpty()){
            while(!arr2.isEmpty()){
                answer.add(arr2.remove());
            }
        }

        else if(arr2.isEmpty()){
            while(!arr1.isEmpty()){
                answer.add(arr1.remove());
            }
        }
        return answer;
    }
    public static void main(String[] args){
        Step3_1_두배열합치기 T = new Step3_1_두배열합치기();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> arr1 = new LinkedList<>();
        for(int i = 0; i < N; i++)
            arr1.add(sc.nextInt());

        int M = sc.nextInt();
        Queue<Integer> arr2 = new LinkedList<>();
        for(int i = 0; i < M; i++)
            arr2.add(sc.nextInt());

        ArrayList<Integer> answer = T.solution(arr1, arr2);
        for(int num : answer)
            System.out.print(num + " ");
    }
}