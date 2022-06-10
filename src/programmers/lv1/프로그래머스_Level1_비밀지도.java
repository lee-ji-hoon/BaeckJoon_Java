package programmers.lv1;

import java.util.Arrays;
public class 프로그래머스_Level1_비밀지도 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] binaryNumber = new int[n];
        boolean[][] binaryCheck = new boolean[n][n];

        // 2진수 세팅
        binaryNumber[0] = 1;
        for(int i = 1; i < n; i++) binaryNumber[i] = binaryNumber[i-1] * 2;

        System.out.println(Arrays.toString(binaryNumber));

        // 사용한 2진수 체크
        for(int i = 0; i < n; i++){
            int temp1 = arr1[i];
            int temp2 = arr2[i];
            int count = n - 1;
            int binaryIdx = 0;
            while(n > binaryIdx){
                if (temp1 == 0 && temp2 ==0) break;
                if (temp1 > 0 && temp1 >= binaryNumber[count]){
                    temp1 -= binaryNumber[count];
                    binaryCheck[i][binaryIdx] = true;
                }
                if (temp2 > 0 && temp2 >= binaryNumber[count]){
                    temp2 -= binaryNumber[count];
                    binaryCheck[i][binaryIdx] = true;
                }
                binaryIdx++;
                count--;
            }
        }

        // 출력문 만들기
        String[] answer = new String[n];
        for(int i = 0; i < n; i++){
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++){
                if(binaryCheck[i][j]) sb.append("#");
                else sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}
