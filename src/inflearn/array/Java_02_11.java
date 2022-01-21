package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

    /**
     * 1. 반의 학생 수 입력
     * 2. 둘째줄 부터 1번 학생부터 1~5학년까지 몇 반에 속했었는지 5개의 정수를 빈칸 두고 출력이니 StringTokenizer 사용해서 구분
     * 3. 어느 학생이 가장 많은 학생들과 같은 반을 했는지 찾아야함 (중복으로 하는 건 의미 없음)
     *  3-1. A B C D E 5명 학생 주어지는데 A가 B랑 5년동안 같은 반이였다고 해도 1번으로 친다.
     *  3-2. A 학생의 1~5학년의 반을 for문의 i로 지정 후 B학생의 1~5학년의 반 비교 하면서 같은 값 있으면 빠져 나오고 C~E 반복
     * 4. 위에 방법으로 같은 반 학생있으면 cnt 증가시킨 후 마지막 for문 끝나고 answer에 저장 후 max 값 추출
     * 5. 끝
     */

public class Java_02_11 {

    public int solution(int N, int[][] temp) {

        int answer = 0; // 리턴할 값
        int max = Integer.MIN_VALUE; // 최대값 찾기

        for (int i = 0; i < N; i ++){ // i 학생

            int cnt = 0;
            for (int j = 0; j < N; j++) { // j 학생
                for (int k = 0; k < 5; k++) { // 학년
                    if (temp[i][k] == temp[j][k]) { // i학생의 반과 j학생의 반을 비교

                        cnt++;
                        break; // 동일한 학생이 들어갈 필요가 없으므로 break 해서 나간다.
                    }
                }
            }
            if (cnt > max){
                max = cnt;
                answer = i + 1; // 1부터가 아닌 0부터 시작이므로 i + 1 해준다.
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java_02_11 T = new Java_02_11();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] temp = new int[N][5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) { // 5학년 까지 고정이므로 0 ~ 4 반복
                int num = Integer.parseInt(st.nextToken());
                temp[i][j] = num;
            }
        }
        System.out.println(T.solution(N, temp));
    }
}

