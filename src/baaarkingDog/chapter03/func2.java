package baaarkingDog.chapter03;

import java.util.Arrays;

public class func2 {

    void func3(int arr[], int N){
        int answer = 0;

        for (int i = 0; i < N - 1; i++) { // N * 2
            for (int j = i + 1; j < N; j++) { // N *( 1 + 2 + 2 + 1)
                if (arr[i] + arr[j] == 100) answer++;
            }
        } // 2N * 6N -> 12N^2 -> O(N^2)
        System.out.println(answer);
    }

    static int func2Refactoring(int arr[], int N) {
        int[] occur = new int[101];

        for (int i = 0; i < N; i++) {
            int number = 100 - arr[i]; // 100에서 현재 배열의 값 뺀 값이 occur에 있는지 확인
            if(occur[number] == 1) return 1;

            occur[arr[i]] = 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 53, 77, 60};
        System.out.println(func2Refactoring(arr, 100));
    }
}
