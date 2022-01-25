package inflearn.haspMap_treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 1. S문자열 K문자열 -> S문자열에서 T문자열 찾기(순서 상관x)
 * 2. 문자열 서로 칸에 맞게 비교 후 Sliding window 기준으로 왼쪽1칸 오른쪽1칸 이동 하는 방법으로 풀기
 *  2-1. K의 HashMap 생성(기준이 되는 Map) (hm) + S의 HashMap 생성 (비교가 되는 윈도우) (temp)
 * 3. 오른쪽으로 이동한 값이 S의 길이 만큼 될 때까지 반복
 *  3-1. temp안에 S.charAt(right) put 시키기
 *  3-2 hm.equals(temp) true -> answer++
 *  3-3. 이동 후 비교해야 하므로 left의 value 값 - 1
 *  3-4. left의 value 값이 0인 경우 remove
 * 4. return answer;
 */
public class Java04_04 {

    public int solution(String S, String K) {

        int answer = 0, left = 0;
        HashMap<Character, Integer> hm = new HashMap<>(); // 기준이 되는 map
        HashMap<Character, Integer> temp = new HashMap<>(); // 비교가 될 map

        for (char x : K.toCharArray()) hm.put(x, hm.getOrDefault(x, 0) + 1); // 기준이 되는 K map 생성

        int N = K.length() - 1;
        for (int i = 0; i < N; i++) {
            temp.put(S.charAt(i), temp.getOrDefault(S.charAt(i), 0) + 1); // window 생성
        }



        for (int right = N; right < S.length(); right++) {
            temp.put(S.charAt(right), temp.getOrDefault(S.charAt(right), 0) + 1); // 오른쪽으로 1칸 이동

            if (hm.equals(temp)) {
                answer++; // hm, temp 서로 같을 경우 answer++
            }

            temp.put(S.charAt(left), temp.get(S.charAt(left)) - 1);
            // left의 값을 없앨지 유지할지 확인하기 위해서 left칸의 value - 1
            // value == 1 -> 본인 말고는 동일한 값이 없다. -> 그러므로 -1 해서 0으로 만든 다음 remove 해줘야함
            // value >= 2 -> 본인 말고도 동일한 값이 있다. -> remove 해버릴 경우 본인 말고 다른 칸의 동일한 값도 사라지기 때문에 remove 하면 안됨

            if(temp.get(S.charAt(left)) == 0) {
                temp.remove(S.charAt(left));
            }

            left++;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java04_04 T = new Java04_04();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String K = br.readLine();

        System.out.println(T.solution(S, K));
    }
}
