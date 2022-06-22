package inflearn.review.step6;
import java.util.Scanner;

public class Step6_2_버블정렬 {
    public static int[] bubble_sort(int[] a, int size) {
        // round는 배열 크기 - 1 만큼 진행됨
        for(int i = 1; i < size; i++) {
            // 각 라운드별 비교횟수는 배열 크기의 현재 라운드를 뺀 만큼 비교함
            for(int j = 0; j < size - i; j++) {

                /*
                 *  현재 원소가 다음 원소보다 클 경우
                 *  서로 원소의 위치를 교환한다.
                 */
                if(a[j] > a [j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
        return a;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int[] answer = bubble_sort(arr, N);
        for(int num : answer)
            System.out.print(num + " ");
    }
}