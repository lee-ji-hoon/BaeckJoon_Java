package programmers.lv2.kakao;

import java.util.Arrays;
import java.util.Comparator;

class 프로그래머스_Level2_파일명정렬_카카오 {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                // 같은 문자열인 경우
                if(result == 0)
                    result = converNum(o1, head1) - converNum(o2, head2);

                return result;
            }
        });
        return files;
    }

    public int converNum(String str, String head){
        str = str.substring(head.length());
        String result = "";

        for(char ch : str.toCharArray())
            if(Character.isDigit(ch) && result.length() < 5)
                result += ch;
            else
                break;

        return Integer.parseInt(result);
    }
}
