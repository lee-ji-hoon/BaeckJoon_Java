package baekjoon.implement;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_2750_수정렬하기 {
    static int[] solution(int[] arr){
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] answer = solution(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
