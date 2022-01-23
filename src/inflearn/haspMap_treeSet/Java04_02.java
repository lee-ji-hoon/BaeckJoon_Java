package inflearn.haspMap_treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 1. 첫 줄 단어(A) 둘째 줄 단어(B)
 * 2. A를 Map 입력
 *  2-1. B를 Map에 getOrDefault(x, 0) == 0 이용해서 true -> answer = NO, break;
 *  2-2. false 경우 map에 현재 존재하는 것이므로 x값의 value를 -1 해줘야한다.
 *  // 2-2의 이유는 AAABB, AABB비교 할 경우 A와 B의 value 값은 다르지만 존재한다는 이유로 if문을 ture로 빠져나가기 때문에 존재 할 경우 value 값을 -1 해줘야 한다.
 * 3. return answer
 */
public class Java04_02 {

    public String solution(String str1, String str2) {

        String answer = "YES";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : str1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (char x : str2.toCharArray()) {
            if (map.getOrDefault(x, 0) == 0) {
                answer = "NO";
                break;
            }else map.put(x, map.get(x) - 1);
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        Java04_02 T = new Java04_02();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(T.solution(str1, str2));

    }
}
