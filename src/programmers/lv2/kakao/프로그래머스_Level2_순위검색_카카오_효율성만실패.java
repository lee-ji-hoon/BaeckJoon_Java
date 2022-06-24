package programmers.lv2.kakao;
import java.util.Set;
import java.util.HashSet;

class 프로그래머스_Level2_순위검색_카카오_효율성만실패 {
    static Set<String[]> java = new HashSet<>();
    static Set<String[]> python = new HashSet<>();
    static Set<String[]> cpp = new HashSet<>();
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        setLanguage(info);

        int count = 0;
        for(String str : query){
            String s = str.replaceAll("and", "");
            String last = s.replaceAll("  ", " ");
            String[] temp = last.split(" ");

            int num = findInfo(temp[0], temp, info);
            answer[count++] = num;
        }

        return answer;
    }

    // [0]언어 : java, pyhton, cpp -
    // [1]직군 : backend, forntend -
    // [2]경력 : junior, senior -
    // [3]푸드 : chicken, pizza -
    // [4]점수 : 점수
    public int findInfo(String type, String[] query, String[] info){
        int count = 0;
        switch(type){
            case "java" : {
                // 자바로 등록돼 있는 set 가져오기
                count = getCount(query, count, java);
                break;
            }
            case "python" : {
                // 파이썬으로 등록돼 있는 set 가져오기
                count = getCount(query, count, python);
                break;
            }
            case "cpp" : {
                // cpp로 등록돼 있는 set 가져오기
                count = getCount(query, count, cpp);
                break;
            }
            default:{
                for(String str : info){
                    // 단 '-' 인 경우도 고려해서 -이면 비교 패스
                    boolean flag = true;
                    String[] temp = str.split(" ");
                    for(int i = 1; i < temp.length - 1; i++){
                        if(query[i].equals("-"))
                            continue;
                        else if(!temp[i].equals(query[i]))
                            flag = false;
                    }
                    // 마지막 점수 비교
                    int queryExam = Integer.parseInt(query[temp.length - 1]);
                    int myExam = Integer.parseInt(temp[temp.length - 1]);
                    if(flag && myExam >= queryExam)
                        count++;
                }
            }
        }
        return count;
    }

    private int getCount(String[] query, int count, Set<String[]> cpp) {
        for(String[] str : cpp){
            // 단 '-' 인 경우도 고려해서 -이면 비교 패스
            boolean flag = true;
            for(int i = 1; i < str.length - 1; i++){
                if(query[i].equals("-"))
                    continue;
                else if(!str[i].equals(query[i])) {
                    flag = false;
                    break;
                }
            }
            // 마지막 점수 비교
            int queryExam = Integer.parseInt(query[str.length - 1]);
            int myExam = Integer.parseInt(str[str.length - 1]);
            if(flag && myExam >= queryExam)
                count++;
        }
        return count;
    }

    public void setLanguage(String[] info){
        for(String str : info){
            String[] temp = str.split(" ");
            switch(temp[0]){
                case "java" :{
                    java.add(temp);
                    break;
                }
                case "python" :{
                    python.add(temp);
                    break;
                }
                case "cpp" : {
                    cpp.add(temp);
                    break;
                }
            } // switch 끝
        }
    }

    public static void main(String[] args) {
        프로그래머스_Level2_순위검색_카카오_효율성만실패 s = new 프로그래머스_Level2_순위검색_카카오_효율성만실패();
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        int[] solution = s.solution(info, query);
        for (int i : solution) {
            System.out.print(i + " ");
        }
    }
}
