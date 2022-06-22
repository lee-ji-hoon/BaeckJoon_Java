package inflearn.review.step6;

import java.util.Scanner;

public class Step6_3_삽입정렬 {
    private static int[] insertion_sort(int[] a, int size) {
        for(int i = 1; i < size; i++) {
            // 타겟 넘버
            int target = a[i];

            int j = i - 1;

            // 타겟이 이전 원소보다 크기 전 까지 반복
            while(j >= 0 && target < a[j]) {
                a[j + 1] = a[j];	// 이전 원소를 한 칸씩 뒤로 미룬다.
                j--;
            }

            /*
             * 위 반복문에서 탈출 하는 경우 앞의 원소가 타겟보다 작다는 의미이므로
             * 타겟 원소는 j번째 원소 뒤에 와야한다.
             * 그러므로 타겟은 j + 1 에 위치하게 된다.
             */
            a[j + 1] = target;
        }
        return a;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int[] answer = insertion_sort(arr, N);
        for(int num : answer)
            System.out.print(num + " ");
    }
}
