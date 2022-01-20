package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1 가위 1은 2한테 지고 3한테 이긴다.
 * 2 바위 2는 1을 이기고 3한테 진다.
 * 3 보  3은 1한테 지고 2한테 이기고.
 */
public class Java_02_03 {

    public String solution(int N, int[] ATemp, int[] BTemp) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // A가 이기는 경우 3개 처리 + 비기는 경우 한 뒤 나머지는 B가 이긴 것이므로 else 처리
            if (ATemp[i] == BTemp[i]) { // 비길 경우
                sb.append("D").append("\n");
            }
            else if (ATemp[i] == 1 && BTemp[i] == 3) { // 가위 보
                sb.append("A").append("\n");
            }

            else if (ATemp[i] == 2 && BTemp[i] == 1) { // 바위 가위
                sb.append("A").append("\n");
            }
            else if (ATemp[i] == 3 && BTemp[i] == 2) { // 보 바위
                sb.append("A").append("\n");
            }
            else{ // A가 이기는 경우가 아니고 비기는 경우도 아니면 B가 승리이므로 else로 처리
                sb.append("B").append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {

        Java_02_03 T = new Java_02_03();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 가위바위보 게임 수
        StringTokenizer A = new StringTokenizer(br.readLine(), " "); // A 학생의 가위바위보 값 토큰 저장
        StringTokenizer B = new StringTokenizer(br.readLine(), " "); // B 학생의 가위바위보 값 토큰 저장

        int[] ATemp = new int[N]; // A 배열 초기화
        int[] BTemp = new int[N]; // B 배열 초기화

        for (int i = 0; i < N; i++) {
            ATemp[i] = Integer.parseInt(A.nextToken()); // Atemp에 A학생 가위바위보 토큰 값 저장
            BTemp[i] = Integer.parseInt(B.nextToken()); // Btemp에 A학생 가위바위보 토큰 값 저장
        }

        System.out.println(T.solution(N, ATemp, BTemp));

    }
}
