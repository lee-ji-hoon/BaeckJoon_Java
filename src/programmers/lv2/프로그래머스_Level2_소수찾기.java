package programmers.lv2;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

class 프로그래머스_Level2_소수찾기 {
    Set<Integer> numberSet = new HashSet<>();

    public boolean isPrime(int num){
        // 1. 0과 1은 소수가 아니다.
        if(num == 0 || num == 1)
            return false;
        // 2. 에라토스트네스의 체의 limit을 계산한다.(num의 루트 값)
        int limit = (int) Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 limit 까지만 배수 여부를 확인한다.
        for(int i = 2; i <= limit; i++)
            if(num % i == 0)
                return false;
        // 4. 위의 배수 여부 확인 결과까지 확인해서 여기까지 오면 소수라는 의미이다.
        return true;
    }

    // comb = 현재 조합 수
    // ohters = 남은 수
    public void recursive(String comb, String others){
        // 1. 현재 조합을 set에 추가한다.
        if(!comb.equals(""))
            numberSet.add(Integer.valueOf(comb));
        // 2. 남은 숫자 중 한 개를 더 해 새로운 조합을 만든다.
        for(int i = 0; i < others.length(); i++)
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i+1));
    }



    public int solution(String numbers) {
        int answer = 0;
        // 1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);
        // 2. 소수의 개수만 센다.
        Iterator<Integer> it = numberSet.iterator();
        while(it.hasNext()){
            int number = it.next();
            if(isPrime(number))
                answer++;
        }
        // 3. 소수의 개수를 반환한다.
        return answer;
    }
}