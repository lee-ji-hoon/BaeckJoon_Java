package inflearn.review.step6;

import java.util.Scanner;

public class Step6_1_선택정렬 {
    public int[] solution(int[] a, int size) {
        for(int i = 0; i < size - 1; i++) {
            int min_index = i;
            // 최솟값을 갖고있는 인덱스 찾기
            for(int j = i + 1; j < size; j++) {
                if(a[j] < a[min_index]) {
                    min_index = j;
                }
            }
            // i번째 값과 찾은 최솟값을 서로 교환
            swap(a, min_index, i);
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args){
        Step6_1_선택정렬 T = new Step6_1_선택정렬();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int[] answer = T.solution(arr, N);
        for(int num : answer)
            System.out.print(num + " ");

    }
}