package baaarkingDog.chapter02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_2562_최댓값 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];

        int max = Integer.MIN_VALUE;
        int maxIndexNum = 0;
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
                maxIndexNum = i+1;
            }
        }
        System.out.println(max);
        System.out.println(maxIndexNum);
    }
}