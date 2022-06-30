package programmers.lv2;

public class 프로그래머스_Lv2_타겟넘버_dfs {
    private static int answer;
    public int solution(int[] numbers, int target) {
        DFS(numbers, 0, target, 0);
        return answer;
    }

    public void DFS(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length) { // 마지막 노드까지 탐색했는지 확인
            if(target == sum) answer ++; // 마지막 노드까지의 합이 target인지 확인
        } else{
            DFS(numbers, depth + 1, target, sum + numbers[depth]); // 더할 경우
            DFS(numbers, depth + 1, target, sum - numbers[depth]); // 뺄 경우
        }
    }
}
