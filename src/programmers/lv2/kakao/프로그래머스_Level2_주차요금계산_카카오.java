package programmers.lv2.kakao;

import java.util.*;

class 프로그래머스_Level2_주차요금계산_카카오 {
    // fees[0] == 기본 시간 | records[0] == 시간
    // fees[1] == 기본 요금 | records[1] == 차량 번호
    // fees[2] == 단위 시간 | records[2] == IN,OUT
    // fees[3] == 단위 요금
    public int[] solution(int[] fees, String[] records) {
        // <차량 번호, 누적 주차 시간>
        Map<String, Integer> feeMap = new TreeMap<>();
        // 주차중인 차량 <차량 번호, 시간>
        Map<String, String> map = new HashMap<>();
        for (String record : records) {
            String[] temp = record.split(" ");
            String car = temp[1];
            String time = temp[0];
            // 들어온 경우
            if(temp[2].equals("IN"))
                map.put(car, time);
            // 나간 경우
            else{
                // 분 차이 구하기
                String in = map.get(car);
                String out = time;
                long diffMinutes = findTime(in, out);
                feeMap.merge(car, (int) diffMinutes, Integer::sum);

                map.remove(car);
            }
        }

        // 들어왔지만 나간게 찍힌게 없을 경우
        for (String s : map.keySet()) {
            String in = map.get(s);
            String out = "23:59";
            long diffMinutes = findTime(in, out);
            feeMap.merge(s, (int) diffMinutes, Integer::sum);
        }

        // 요금 구하기
        int basicTime = fees[0];
        int basicFees = fees[1];
        int unitTime = fees[2];
        int unitRate = fees[3];

        int[] answer = new int[feeMap.size()];

        int count = 0;
        for (int value : feeMap.values()) {
            int totalFee = 0;
            int fee = 0;

            int minutes = value - basicTime;
            if(minutes > 0){
                // 올림 판단 여부 확인
                int rest = minutes % unitTime;

                // 나머지가 존재하면 올려야 한다. 몫에 + 1;
                if(rest > 0){
                    fee = ((minutes / unitTime) + 1) * unitRate;
                } else {
                    fee = minutes / unitTime * unitRate;
                }
                // 총 요굼 = 기본 요금 + 추가 요금 + 원래요금
                totalFee = basicFees + fee;
                answer[count] = totalFee;
                // 기본 요금만
            } else{
                answer[count] = basicFees;
            }
            count++;
        }

        System.out.println(Arrays.toString(answer));
        return answer;
    }

    /*public long findTime(String in, String out){
        SimpleDateFormat s = new SimpleDateFormat("HH:mm");
        Date inTime = null;
        Date outTime = null;
        try{
            inTime = s.parse(in);
            outTime = s.parse(out);
        } catch(Exception e){ }

        long diffMinutes = (outTime.getTime() - inTime.getTime()) / (60 * 1000);
        return diffMinutes;
    }*/
    public int findTime(String in, String out) {
        int inMin = Integer.parseInt(in.split(":")[1]);
        int inHour = Integer.parseInt(in.split(":")[0]);
        int outMin = Integer.parseInt(out.split(":")[1]);
        int outHour = Integer.parseInt(out.split(":")[0]);

        int hour = outHour - inHour;
        int minute = outMin - inMin;

        return hour * 60 + minute;
    }

    public static void main(String[] args) {
        프로그래머스_Level2_주차요금계산_카카오 s = new 프로그래머스_Level2_주차요금계산_카카오();
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        s.solution(fees, records);

    }
}