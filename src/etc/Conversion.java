package etc;

import java.util.Scanner;

public class Conversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("몇 진수를 입력하시겠습니까? (2~16 진수만 가능합니다.)");
        int N = sc.nextInt();

        System.out.println("변환할 수를 입력해주세요.");
        String number = sc.next();

        // 입력 받은 숫자를 10진법으로 바꿔준다.
        int decimal = toDecimal(N, number);
        System.out.println(N + "진수인 "+ number + "를" + " 10진수로 변환한 결과 : " + decimal);

        System.out.println("몇 진수로 바꾸시겠습니까?");
        int K = sc.nextInt();
        String answer = conversionToK(decimal, K);

        System.out.println("answer = " + answer);
    }

    // 10진수를 K진수로 변환.
    private static String conversionToK(int decimal, int K) {
        StringBuilder sb = new StringBuilder();

        int current = decimal;

        while(current > 0) {
            // N진법으로 나누었는데 10보다 작으면 바로 추가
            if(current % K < 10)
                sb.append(current % K);

            // 10이상은 알파벳으로 표기한다.
            else
                // 10진수를 구해주는 법과 반대로 수행해주면 된다. 10이상의 수부터 표현할 수 있기 때문에 10을 빼주는 것이다.
                sb.append((char)(current % K - 10 + 'A'));

            current /= K;
        }
        return sb.reverse().toString();
    }

    // N 진수를 10진수로 변환
    private static int toDecimal(int N, String number) {
        int result = 0;

        //10 진법인 경우 바로 리턴
        if (N == 10)
            return Integer.parseInt(number);
        else if (N >= 2 && N <= 16) {
            char[] num = number.toCharArray();
            // 0부터 시작하여 진수와 곱해주고 각 자리 숫자를 더해준다.
            // 그 결과를 다음 자리수로 갈 때 진수와 곱해주고 현재 자리수 값을 더해준다.
            // 반복
            for (char c : num) {
                if (!errorCheck(c, N)) {
                    System.out.println("잘못된 입력입니다. 프로그램을 다시 실행해주세요.");
                    System.exit(0);
                }
                result = result * N + (c - '0');
            }
        }
        else{
            System.out.println("계산할 수 없는 진수입니다. 다시 실행해주세요.");
            System.exit(0);
        }
        return result;
    }
    // 주어진 진법 보다 높은 숫자가 입력으로 들어오면 오류.
    private static boolean errorCheck(char num, int notation) {
        int n = 0;
        if(num >= 'A')
            n = num - 'A' + 10;
        else
            n = num - '0';
        return n < notation;
    }
}
