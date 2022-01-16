package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java01_04 {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    public String solution(int N) throws IOException {

         for (int i = 0; i < N; i++) {
             String reverse = "";
             String str = br.readLine();

             for (int j = str.length() - 1; j >= 0; j--) {
                 reverse = reverse + str.charAt(j); // 끝에서부터 다시 저장
             }
             sb.append(reverse).append("\n");
         }
         return sb.toString();
     }

     public static void main(String[] args) throws IOException {

         Java01_04 t = new Java01_04();
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int N = Integer.parseInt(br.readLine());

         System.out.println(t.solution(N));
     }
}
