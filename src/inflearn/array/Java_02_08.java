package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 1. 첫 줄 학생 수 입력
 * 2. 두 번째 줄 국어점수 N개의 점수 입력.
 * 3. 등수 출력이므로 국어 점수 배열 i -> N까지 비교하면서 더 큰 값이 있을때마다 cnt 값 증가 후 마지막에 answer 배열에 등수 입력
 * 4. 같은 점수가 있을 경우 높은 등수로 처리이므로 같은 경우는 아무것도 안해주면 됨
 *
 */
public class Java_02_08 {

    public ArrayList<Integer> solution(int N, int[] temp) {

        ArrayList<Integer> answer = new ArrayList<>(N);
        for (int i = 0; i <N ; i++) {
            int cnt = 1;
            for (int j = 0; j < N; j++) {
                if(temp[i] < temp[j]) cnt++;
            }
            answer.add(cnt);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java_02_08 T = new Java_02_08();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        for (int x : T.solution(N, temp)) System.out.print(x + " ");

    }
}
