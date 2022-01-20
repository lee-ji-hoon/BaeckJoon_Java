package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Java_02_06 {

    public ArrayList<Integer> solution(int N, String[] temp) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[] number = new int[N];

        for (int i = 0; i < N; i++) {
            number[i] =Integer.parseInt(new StringBuilder(temp[i]).reverse().toString()); // 입력 받은 값 reverse로 뒤집어 준 다음 정수형 변환 해서 number 저장

            int res = number[i];

            if(isPrime(res)) answer.add(res); // isPrime에 res 값 넘기고 return 된 값이 true 면 answer 배열에 res 객체 추가
        }

        return answer;
    }

    public boolean isPrime(int num) { // number 객체의 값들 소수 체크
        if (num == 1) return false; // 1이면 소수가 아니니 바로 return false
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        Java_02_06 T = new Java_02_06();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String[] temp = new String[N];
        for (int i = 0; i < N; i++) {
            temp[i] = st.nextToken();
        }
        for (int x : T.solution(N, temp)) System.out.print(x + " ");
    }
}
