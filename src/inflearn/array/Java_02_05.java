package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 에라토스테네스 체
 */
public class Java_02_05 {

    public int solution(int n) {

        int answer = 0;
        int[] ch = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer ++;
                for (int j = i; j <= n; j=j+i) { // j가 i의 배수만큼 증가해야 하므로 j = j + i;
                    ch[j] = 1;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java_02_05 T = new Java_02_05();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(T.solution(N));
    }
}
