package inflearn.etc;

public class 카드점수 {
    public int solution(int[] nums, int k){
        int answer=0;
        for(int x : nums) answer+=x;
        int remain=nums.length-k;
        int sum=0;
        for(int i=0; i<remain; i++) sum+=nums[i];
        int Nmin=sum;
        for(int i=remain; i<nums.length; i++){
            sum+=(nums[i]-nums[i-remain]);
            Nmin=Math.min(Nmin, sum);
        }
        return answer-Nmin;
    }


    public static void main(String[] args) {
        카드점수 T = new 카드점수();

        int[] arr1={3, 2, 5, 6, 7, 1};
        System.out.println(T.solution(arr1, 3)); //14
        int[] arr2={3, 1, 4, 5, 4, 1, 2, 5};
        System.out.println(T.solution(arr2, 5)); //18
        int[] arr3={6, 7, 1, 3, 1, 4, 3, 1, 1, 5, 4, 1, 2, 5};
        System.out.println(T.solution(arr3, 10)); //35
    }
}
