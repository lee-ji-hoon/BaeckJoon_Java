package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java_02_12 {

    /**
     * 1. 학생 수 N명 M개의 줄로 이루어진 수학테스트 결과
     * 2. 멘토(선생) / 멘티(학생)
     *  2-1. A(멘토) B(멘티)가 될려면 M번의 테스트에서 모두 A학생의 등수가 더 높아야한다
     *  2-2. A학생과 B학생을 첫번째 시험부터 비교해서 높을 때 마다 cnt ++
     *  2-3. cnt 값이 mathTestColumn 같다면 answer++ 증가 (멘토 멘티가 가능하다는 말)
     * 3. 4중 for문
     */

    public int solution(int[][] temp, int student, int mathTestColumn) {

        int answer = 0;
        for(int i = 1; i <= student; i ++) { // i 학생의 등수
            for (int j = 1; j <= student; j++) { // j 학생의 등수

                int cnt = 0;
                for (int h = 0; h < mathTestColumn; h++) {
                    int pi = 0, pj = 0;

                    for (int k = 0; k < student; k++) {
                        if (temp[h][k] == i) pi = k; // i 학생의 등수 k만 바뀌므로 왼쪽 -> 오른쪽으로 가면서 확인
                        if (temp[h][k] == j) pj = k; // j 학생의 등수
                    }
                    if (pi < pj) cnt++; // 멘토인 i 학생의 값이랑 j 학생의 값 비교
                }
                if (cnt == mathTestColumn) { // 한번이라도 i의 등수가 j의 등수보다 높지 않으면 cnt == mathTestColumn 이 false가 된다.
                    answer++;
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {

        Java_02_12 T = new Java_02_12();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int student = Integer.parseInt(st.nextToken());
        int mathTestColumn = Integer.parseInt(st.nextToken());

        int[][] temp = new int[mathTestColumn][student];
        for (int i = 0; i < mathTestColumn; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < student; j++) {
                int num = Integer.parseInt(st.nextToken());
                temp[i][j] = num;
            }
        }

        System.out.println(T.solution(temp, student, mathTestColumn));
    }
}
