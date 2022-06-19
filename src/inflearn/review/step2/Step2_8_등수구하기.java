package inflearn.review.step2;
import java.util.Scanner;

public class Step2_8_등수구하기 {
    public int[] solution(int[] arr){
        int[] answer = new int[arr.length];

        for(int i = 0; i < arr.length; i++){
            int count = 1;
            for(int j = 0; j < arr.length; j++){
                if(arr[i] < arr[j])
                    count++;
            }
            answer[i] = count;
        }

        return answer;
    }

    public static void main(String[] args){
        Step2_8_등수구하기 T = new Step2_8_등수구하기();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int[] answer = T.solution(arr);
        for(int num : answer)
            System.out.print(num + " ");
    }
}
