package inflearn.string;

        /*
        설명
        한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
        문장속의 각 단어는 공백으로 구분됩니다.

        입력
        첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.

        출력
        첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한
        단어를 답으로 합니다.
        */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Java01_03 {

    public String solution(String str) {
        int m = Integer.MIN_VALUE; // 제일 작은 값으로 초기화
        String answer = "";
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(str, " "); // 넘어온 str을 공백 기준으로 구분해줌

        while (st.hasMoreTokens()) { // 모든 토큰을 반복
            String x = st.nextToken(); // 구분한 토큰을 저장
            int len = x.length(); // 토큰의 길이값 저장 study => 5

            if (len > m) { // 같다로 할 경우 뒤에 같은 길이의 단어가 있으면 그 단어로 바뀌어서 >=이 아닌 >이여야만한다.
                m = len;
                answer = x;
            }
        }
        sb.append(answer);
        return sb.toString(); // 배열이 아닌 String으로 변환 후 return
    }

    public static void main(String[] args) throws IOException {
        Java01_03 t = new Java01_03();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(t.solution(str));

    }
}
