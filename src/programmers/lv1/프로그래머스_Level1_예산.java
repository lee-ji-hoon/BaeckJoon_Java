package programmers.lv1;

import java.util.Arrays;

class 프로그래머스_Level1_예산 {
    // 최대한 많은 부서의 물품을 구매
    // 신청한 금액만큼 모두 지원 1000원 지원 -> 무조건 1000원 지원 그 아래나 위는 불가능

    // 신청한 금액 배열 d
    // 예산          budget
    // return 최대 몇 개의 부서에 물품을 지원할 수 있는지

    // 1 <= d.length(부서 수) <= 100
    // 1 <= d[i](신청금액) <= 100,000
    // 1 <= budget(예산안) <= 10,000,000

    static int answer;
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int answer = 0;
        for(int amount : d){
            budget -= amount;
            if(budget < 0) break;
            answer++;
        }
        // dfs(d, budget, 0, 0, 0);

        return answer;
    }

    static void dfs(int[] d, int budget, int depth, int sum, int count){
        if(sum == budget) {
            answer = Math.max(answer, count);
            return;
        }
        if(depth == d.length) return;
        else{
            dfs(d, budget, depth + 1, sum + d[depth], count + 1);
            dfs(d, budget, depth + 1, sum, count);
        }
    }

    public static void main(String[] args) {
        프로그래머스_Level1_예산 solution = new 프로그래머스_Level1_예산();
        int[] d = {1,3,2,5,4};

        solution.solution(d, 9);
    }
}
