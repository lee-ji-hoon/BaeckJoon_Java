package inflearn.haspMap_treeSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *  1. 학생수(N), 알파벳(N개) 입력
 *  2. for each로 map.put 하기
 *   2.1 map.getOrDefault("odject", "default value") x값이 존재하면 존재하는 값의 + 1 없으면 x값 map에 추가 후 + 1
 *  3. max값 지정
 *  4. for each 로 map keySet() -> map 있는 모든 object 대입
 *   4-1. if 현재 입력 된 map.get(object) > max 비교
 *    4-1-1. true인 경우 max = map.get(x), answer = x;
 *  5. return answer;
 */

public class Java04_01 {

    public char solution(int N, String str) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1); // getOrDefault(x) x값 찾아감 만약 없다면 0을 반환
        }

        int max = Integer.MIN_VALUE;

        for (char x : map.keySet()) { // map에 있는 모든 알파벳값들 x에 대입
            if(map.get(x) > max){ //
                max = map.get(x);
                answer = x;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {

        Java04_01 T = new Java04_01();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(T.solution(N, str));
    }
}
