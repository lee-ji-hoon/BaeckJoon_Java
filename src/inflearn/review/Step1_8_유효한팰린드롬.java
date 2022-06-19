package inflearn.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step1_8_유효한팰린드롬 {

    public String solution(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++)
          if(Character.isAlphabetic(str.charAt(i))) sb.append(str.charAt(i));

        String temp = sb.toString().toUpperCase();
        int lt = 0;
        int rt = temp.length() - 1;

        while(lt < rt){
            if(temp.charAt(lt) != temp.charAt(rt))
                return "NO";
            lt++;
            rt--;
        }
        return "YES";
    }
    public static void main(String[] args) throws IOException {
        Step1_8_유효한팰린드롬 T = new Step1_8_유효한팰린드롬();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        System.out.println(T.solution(str));

    }
}
