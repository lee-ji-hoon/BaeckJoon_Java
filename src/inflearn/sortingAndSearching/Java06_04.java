package inflearn.sortingAndSearching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 캐시의 크기 S, 작업의 개수 N 입력
 * 2. answer[S] 배열 생성
 * 3. foreach 임시 배열 위치 index 생성 -> 0로 지정
 *  3-1. for(0 ~ S) if answer[i] == x -> index = i; 위치 새로 지정
 *  3-2. if(index = -1)
 *   3-2-1. for문 S-1 부터 1까지 -- 오른쪽부터 왼쪽으로 반복
 *   3-2-2. answer[i] = answer[i-1]
 *  3-3 else
 *   3-3-1. 3-2반복 하지만 index 부터 1까지
 * 4. return answer;
 */
public class Java06_04 {
    public int[] solution(int S, int N, int[] arr) {

        int[] answer = new int[S];

        for (int i : arr) {
            int index = -1;
            for (int j = 0; j < S; j++) {
                if (answer[j] == i) index = j; // answer 안에 i값 있는지 확인 후 index 값 변경
            }

            if(index == -1){ // 추가되는 값이 answer 안에 없는 경우
                for (int j = S - 1; j >= 1; j--) {
                    answer[j] = answer[j - 1]; // 오른쪽 부터 왼쪽으로 이동
                }
            }else{ // 추가도는 값이 answer 안에 있는 경우
                // for문의 시작을 index부터 시작
                for (int j = index; j >= 1; j--) {
                    answer[j] = answer[j - 1];
                }
            }
            answer[0] = i;
//            System.out.println("answer = " + Arrays.toString(answer));
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java06_04 T = new Java06_04();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i : T.solution(S, N, arr)) System.out.print(i + " ");
    }
}
