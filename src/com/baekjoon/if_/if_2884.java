package com.baekjoon.if_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class if_2884 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");

        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (M < 45) { // M(분)이 45분 보다 작으면 H(시)에서 -1 해주고 M은 + 15 해주면 된다.
            H--;
            M = M + 15;
            if (H < 0) { // H가 0이였을 경우 -1이 되므로 다시 24시간 계산식으로 바꿔줘야 한다.
                H = H + 24;
            }
            System.out.println(H + " " + M);
        }else{
            M = M - 45; // 45보다 큰 경우 이므로 다른 것 신경쓸 필요 없이 M만 -45 해주면 된다.
            System.out.println(H + " " + M);
        }
    }
}

