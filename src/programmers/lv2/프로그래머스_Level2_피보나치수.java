package programmers.lv2;

class 프로그래머스_Level2_피보나치수 {

    static int[] arr = new int[100_001];

    public int fibo(int number){
        if(arr[number] != 0) return arr[number];
        else{
            arr[number] = (fibo(number-2) + fibo(number-1))%1234567;
        }
        return arr[number];
    }

    public int solution(int n) {
        int answer = 0;

        arr[0] = 0;
        arr[1] = arr[2] = 1;
        answer = fibo(n);
        return answer;
    }
}