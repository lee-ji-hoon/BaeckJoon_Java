package inflearn.review.step3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Step3_2_공통원소구하기 {
    public ArrayList<Integer> solution(int[] arr1, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<Integer>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int a1 = 0;
        int a2 = 0;
        while(a1 < arr1.length && a2 < arr2.length){
            if(arr1[a1] == arr2[a2]){
                answer.add(arr1[a1]);
                a1++;
                a2++;
            }else if(arr1[a1] > arr2[a2]){
                a2++;
            }else
                a1++;
        }
        return answer;
    }
    public static void main(String[] args){
        Step3_2_공통원소구하기 T = new Step3_2_공통원소구하기();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for(int i = 0; i < N; i++)
            arr1[i] = sc.nextInt();

        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for(int i = 0; i < M; i++)
            arr2[i] = sc.nextInt();

        ArrayList<Integer> answer = T.solution(arr1, arr2);
        for(int num : answer)
            System.out.print(num + " ");
    }
}