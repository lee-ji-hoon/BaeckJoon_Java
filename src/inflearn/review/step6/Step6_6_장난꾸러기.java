package inflearn.review.step6;
import java.util.Scanner;
import java.util.Arrays;

public class Step6_6_장난꾸러기 {
    static int[] solution(int N, int[] arr){
        int[] answer = new int[2];
        int[] temp = arr.clone();

        Arrays.sort(arr);

        int count = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != temp[i]) {
                answer[count] = i;
                count++;
            }

            if(count == 2)
                break;
        }
        Arrays.sort(answer);
        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N+1];

        for(int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();

        int[] answer = solution(N, arr);
        for(int num : answer)
            System.out.print(num + " ");
    }
}