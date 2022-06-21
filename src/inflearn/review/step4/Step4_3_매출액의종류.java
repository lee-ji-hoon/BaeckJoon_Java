package inflearn.review.step4;

import java.util.*;

public class Step4_3_매출액의종류 {
    public ArrayList<Integer> solution(int M, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        int count = 0;
        for (int j : arr) {
            count++;
            queue.add(j);
            map.put(j, map.getOrDefault(j, 0) + 1);

            if (count == M) {
                answer.add(map.size());
                int removeNumber = queue.remove();

                int integer = map.get(removeNumber);
                if (integer == 1)
                    map.remove(removeNumber);
                else
                    map.put(removeNumber, integer - 1);

                count--;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Step4_3_매출액의종류 T = new Step4_3_매출액의종류();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 입력 배열 길이
        int M = sc.nextInt(); // 정답 배열 길이
        int[] arr = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        ArrayList<Integer> answer = T.solution(M, arr);
        for(int num : answer)
            System.out.print(num + " ");
    }
}
