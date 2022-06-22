package inflearn.review.step6;

import java.util.Scanner;

public class Step6_7_좌표정렬_실패 {
    static int[][] arr;

    // i는 현재, j는 다음
    static void swap(int i, int j){
        // x위치 바꾸기
        int xTemp = arr[i][0];
        arr[i][0] = arr[j][0];
        arr[j][0] = xTemp;
        // y위치 바꾸기
        int yTemp = arr[i][1];
        arr[i][1] = arr[j][1];
        arr[j][1] = yTemp;
    }

    static void solution(int[][] arr, int N){
        // x값에 의해서 정렬
        for(int i = 1; i < N; i++){
            for(int j = 0; j < N - i; j++){
                if(arr[j][0] > arr[j+1][0]){
                    swap(j, j+1);
                } else if(arr[j][0] == arr[j+1][0] && arr[j][1] > arr[j+1][1]){
                    swap( j, j+1);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        arr = new int[N][2];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < 2; j++)
                arr[i][j] = sc.nextInt();

        solution(arr, N);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
