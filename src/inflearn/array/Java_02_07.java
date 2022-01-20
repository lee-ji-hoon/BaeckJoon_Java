package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. N 값 입력
 * 2. 0과 1로 이루어진 배열 입력
 * 3. 배열[i] 에 값이 1이면  cnt ++
 * 4. 점수[i] = cnt (연속으로 맞으면 증가)
 * 5. 틀린 경우는 점수[i] = 0 cnt -> 0
 */
public class Java_02_07 {

    public int solution(int N, int[] temp) {

        int cnt = 0; // 연속으로 답 맞히는 경우 가산점을 위한 변수
        int answer = 0; // 점수 값
        for (int i = 0; i < N; i++) {
            if(temp[i] == 1) cnt++; // 1 즉 정답인 경우 cnt 증가
            else cnt = 0; // 1이 아닌 경우 즉 0 틀린 경우 cnt = 0 초기화

            answer = answer + cnt; // 가산점 누적
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java_02_07 T = new Java_02_07();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 채점 결과 입력

        int[] temp = new int[N];
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken()); // 채점 결과 배열에 추가
        }

        System.out.println(T.solution(N, temp));
    }
}
