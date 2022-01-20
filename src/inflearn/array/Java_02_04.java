package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_02_04 {

    public int[] solution(int N) {
        int answer[] = new int[N];

        int num = 1;
        answer[0] = answer[1] = 1;
        for (int i = 2; i < N; i++) {
            answer[i] = answer[i - 2] + answer[i - 1];
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java_02_04 T = new Java_02_04();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int x : T.solution(N)) System.out.print(x +" ");
    }
}
