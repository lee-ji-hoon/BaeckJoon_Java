package programmers.lv2;

class 프로그래머스_Level2_스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] skillCount = new int[skill.length()];

        for(String str : skill_trees){
            for(int i = 0; i < skill.length(); i++){
                skillCount[i] = str.indexOf(skill.charAt(i)) + 1;
            }
            if(checkSkill(skillCount))
                answer += 1;
        }
        return answer;
    }

    public boolean checkSkill(int[] skillCount){
        for(int i = 0; i < skillCount.length - 1; i++){
            // 만약 0을 만나면 그 이후 숫자부터는 무조건 0이어야만 한다.
            int cur = skillCount[i];
            if(cur == 0){
                while(i < skillCount.length){
                    if(skillCount[i] != 0){
                        return false;
                    }
                    i++;
                }
                // 현재 숫자에서 이후 숫자들 값 확인하기
            } else {
                for(int j = i+1; j < skillCount.length; j++){
                    int next = skillCount[j];
                    if(next == 0)
                        continue;

                    else if(cur > next)
                        return false;
                }
            }
        }

        return true;
    }

}
