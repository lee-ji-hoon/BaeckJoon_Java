package baekjoon.inputoutput;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class InputOutput_10718 {
    public static void main(String[] args) throws IOException {

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("강한친구 대한육군");
        bw.newLine(); // \n과 같은 역할
        bw.write("강한친구 대한육군");

        bw.flush(); // 스트림에 들어있는 데이터 비우기
        bw.close(); // 스트림 종료
    }
}
