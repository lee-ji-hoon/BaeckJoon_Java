package programmers.lv2.kakao;

class 프로그래머스_Level2_거리두기확인하기_카카오 {

    public int checkManhattan(String[][] copy){
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(copy[i][j].equals("P")){
                    // 동서남북 확인 => 즉 거리 2
                    if(!check1(i, j, copy))
                        return 0;
                    // 대각선 확인 => 거리 1
                    if(!check2(i, j, copy))
                        return 0;
                }
            }
        }
        return 1;
    }

    public boolean check2(int i, int j, String[][] copy){
        // 북동 -1 +1
        if(i > 0 && j < 4 && copy[i-1][j+1].equals("P"))
            if(!copy[i-1][j].equals("X") || !copy[i][j+1].equals("X"))
                return false;
        // 남동
        if(i < 4 && j < 4 && copy[i+1][j+1].equals("P"))
            if(!copy[i][j+1].equals("X") || !copy[i+1][j].equals("X"))
                return false;
        // 남서
        if(i < 4 && j > 0 && copy[i+1][j-1].equals("P"))
            if(!copy[i+1][j].equals("X") || !copy[i][j-1].equals("X"))
                return false;
        // 북서
        if(i > 0 && j > 0 && copy[i-1][j-1].equals("P"))
            if(!copy[i-1][j].equals("X") || !copy[i][j-1].equals("X"))
                return false;
        return true;
    }

    public boolean check1(int i, int j, String[][] copy){
        // 동
        if(i < 3 && copy[i+1][j].equals("O"))
            if(copy[i+2][j].equals("P"))
                return false;
        if(i != 4 && copy[i+1][j].equals("P"))
            return false;
        // 서
        if(i > 1 && copy[i-1][j].equals("O"))
            if(copy[i-2][j].equals("P"))
                return false;
        if(i != 0 && copy[i-1][j].equals("P"))
            return false;
        // 남
        if(j < 3 && copy[i][j+1].equals("O"))
            if(copy[i][j+2].equals("P"))
                return false;
        if(j != 4 && copy[i][j+1].equals("P"))
            return false;
        // 북
        if(j > 1 && copy[i][j-1].equals("O"))
            if(copy[i][j-2].equals("P"))
                return false;
        if(j != 0 && copy[i][j-1].equals("P"))
            return false;

        return true;
    }

    public String[][] findPlaces(String[] places){
        String[][] find = new String[5][5];

        for(int i = 0; i < 5; i++){
            char[] toChar = places[i].toCharArray();
            for(int j = 0; j < 5; j++){
                find[i][j] = String.valueOf(toChar[j]);
            }
        }
        return find;
    }


    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for(int i = 0; i < 5; i++){
            String[][] copy = findPlaces(places[i]);
            answer[i] = checkManhattan(copy);
        }
        return answer;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_거리두기확인하기_카카오 s = new 프로그래머스_Level2_거리두기확인하기_카카오();
        String[][] ab = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        s.solution(ab);
    }
}
