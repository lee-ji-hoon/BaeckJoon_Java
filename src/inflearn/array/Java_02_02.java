package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_02_02 {

    public int solution(int N, int[] temp) {

        int cnt = 1; // 맨 앞 학생은 무조건 보이므로 0이 아닌 1

        int max = temp[0]; // 맨 앞 학생을 제일 크다고 예시로 만들어둔다.

        for (int i = 1; i < N; i++) {
            if (temp[i] > max) { // max의 값 보다 temp[i] 값이 더 클 경우 선생님 기준에서 보이는 학생이다.
                max = temp[i];
                cnt++;
            } // else 즉 temp[i] < max 인 경우 뒤에 학생이 앞에 학생보다 키가 작다는 말이므로 보이지 않는 학생이므로 아무런 작업을 할 필요가 없다.
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {

        Java_02_02 T = new Java_02_02();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 학생 수
        int[] temp = new int[N]; // 학생의 키를 배열로 받기

        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 공백으로 구분해서 토큰 저장

        for (int i = 0; i < N; i++) { // 토큰에 저장 돼 있는 값들 temp 에 저장
            temp[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(T.solution(N, temp));
    }
}
