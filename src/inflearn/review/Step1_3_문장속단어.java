package inflearn.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step1_3_문장속단어 {
    public String solution(String str){
        String[] temp = str.split(" ");

        String answer = temp[0];
        int length = answer.length();
        for(int i = 1; i < temp.length; i++){
            String target = temp[i];
            int targetLength = target.length();
            if(targetLength > length) {
                answer = target;
                length = targetLength;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Step1_3_문장속단어 T = new Step1_3_문장속단어();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        System.out.print(T.solution(str));

    }
}
