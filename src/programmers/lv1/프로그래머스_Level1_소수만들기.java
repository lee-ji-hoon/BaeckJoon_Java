package programmers.lv1;

public class 프로그래머스_Level1_소수만들기 {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;

        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                for(int k = j+1; k <len; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)) answer += 1;
                }
            }
        }

        return answer;
    }

    // 소수 판별 로직
    public boolean isPrime(int N){
        if(N % 2 == 0) return false;
        int count = 0;
        for(int i = 3; i <= Math.sqrt(N); i += 2){
            if(N % i == 0) return false;
        }
        return true;
    }
}
