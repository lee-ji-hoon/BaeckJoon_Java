package programmers.lv2.kakao;
class 프로그래머스_Level2_방금그곡_카카오 {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        m = changeMelody(m);

        for(String str : musicinfos){
            String[] ch = str.split(",");

            String start = ch[0];
            String end = ch[1];
            String title = ch[2];
            String music = changeMelody(ch[3]);

            int startHour = Integer.parseInt(start.split(":")[0]);
            int startMin = Integer.parseInt(start.split(":")[1]);
            int endHour = Integer.parseInt(end.split(":")[0]);
            int endMin = Integer.parseInt(end.split(":")[1]);

            int time = (endHour - startHour) * 60 + (endMin - startMin);

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < time / music.length(); i++)
                sb.append(music);
            sb.append(music.substring(0, time % music.length()));

            if(sb.toString().contains(m)){
                if(max < sb.toString().length()){
                    max = sb.toString().length();
                    answer = title;
                }
            }
        }

        return answer;
    }

    public String changeMelody(String m){
        m = m.replaceAll("C#" , "c");
        m = m.replaceAll("D#" , "d");
        m = m.replaceAll("F#" , "f");
        m = m.replaceAll("G#" , "g");
        m = m.replaceAll("A#" , "a");

        return m;
    }
}