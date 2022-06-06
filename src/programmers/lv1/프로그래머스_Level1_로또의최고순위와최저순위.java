package programmers.lv1;

public class 프로그래머스_Level1_로또의최고순위와최저순위 {
    // 알 수 없는 번호 0
    // 로또 번호는 6개
    public int[] solution(int[] lottos, int[] win_nums) {
        int currentCount = 0;
        int zeroCount = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCount++;
                continue;
            }
            for (int win_num : win_nums) {
                if (lotto == win_num) {
                    currentCount++;
                    break;
                }
            }
        }

        int min = currentCount;
        int max = currentCount + zeroCount;

        return new int[]{getRank(max), getRank(min)};
    }

    private int getRank(int number) {
        switch (number){
            case 2 : return 5;
            case 3 : return 4;
            case 4 : return 3;
            case 5 : return 2;
            case 6 : return 1;

            default: return 6;
        }
    }
}
