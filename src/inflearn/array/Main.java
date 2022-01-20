package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    /**
     * 1. 학생 수 N명 M개의 줄로 이루어진 수학테스트 결과
     * 2. 멘토(선생) / 멘티(학생)
     *  2-1. A(멘토) B(멘티)가 될려면 M번의 테스트에서 모두 A학생의 등수가 더 높아야한다
     *  2-2. A학생과 B학생을 첫번째 시험부터 비교해서 전부 다 A학생이 높으면 cnt ++ 그게 아닐경우 break 빠져나오기
     *  2-3. 본인의 경우도 생각해야 하므로 = 하지 않기.
     *  2-4. 1 ~ N -> N ~ 1 두 가지 경우
     */

    public int solution(int[][] temp, int student, int mathTestColumn) {

        int cnt = 0;

        for (int i = 0; i < student-1; i++) {
            for (int j = 0; j < mathTestColumn; j++) {
                System.out.println("temp[j][i] ? temp[j+1][i-1] => " + temp[j][i] +" ? "+temp[j+1][i+1]);
                System.out.println(i + " " + j);
                if(temp[i][j] >= temp[i+1][j] ) break;
                else {
                    cnt ++;
                }
            }
        }

/*
        for (int i = student; i > 0; i--) {
            for (int j = 0; j < mathTestColumn; j++) {
                System.out.println("i + j = " + i + " + " + j);
                System.out.println("temp[j][i] ? temp[j+1][i-1] => " + temp[j][i] +" ? "+temp[j+1][i-1]);
                System.out.println(temp[0][4]);
                System.out.println(temp[1][4]);
                if(temp[j][i] >= temp[j+1][i] ) break;
                else {
                    cnt ++;
                }
            }
        }
*/

        return cnt;
    }

    public static void main(String[] args) throws IOException {

        Main T = new Main();

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
