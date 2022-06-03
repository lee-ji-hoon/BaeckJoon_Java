package baaarkingDog.chapter03;

import java.util.Arrays;
import java.util.Scanner;

public class 백준_3273_두수의합 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int x = sc.nextInt();

        Arrays.parallelSort(arr);

        int start = 0;
        int end = n - 1;
        int cnt = 0;
        int sum;

        while (start < end){
            sum = arr[start] + arr[end];
            if(sum == x) cnt ++;
            if(sum <= x) start++;
            else end --;
        }

        System.out.println(cnt);
    }
}
