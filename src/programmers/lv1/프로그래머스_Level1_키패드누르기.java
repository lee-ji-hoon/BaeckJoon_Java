package programmers.lv1;

public class 프로그래머스_Level1_키패드누르기 {
    // 1 4 7 -> 왼
    // 3 6 9 -> 오른
    // 2 5 8 0 -> 왼손 오른손 중에 가까운 것
    // 만약 둘이 같다면 오른손잡이인지 왼손잡이인지 체크
    // 1 2 3
    // 4 5 6
    // 7 8 9
    class Finger{
        int row;
        int column;

        public Finger(int row, int column){
            this.row = row;
            this.column = column;
        }
        public int getRow(){
            return row;
        }
        public int getColumn(){
            return column;
        }
        public void setRow(int row){
            this.row = row;
        }
        public void setColumn(int column){
            this.column = column;
        }
    }

    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        Finger leftFinger = new Finger(3 ,0);
        Finger rightFinger = new Finger(3, 2);
        Finger numberLocation = new Finger(0, 1);

        for(int number : numbers) {
            // 왼손으로 누를 숫자들
            if(number == 1 || number == 4 || number == 7) {
                sb.append("L");
                switch(number){
                    case 1: {
                        leftFinger.setRow(0);
                        leftFinger.setColumn(0);
                        break;
                    }
                    case 4: {
                        leftFinger.setRow(1);
                        leftFinger.setColumn(0);
                        break;
                    }
                    case 7: {
                        leftFinger.setRow(2);
                        leftFinger.setColumn(0);
                        break;
                    }
                }
                continue;
            }
            // 오른손으로 누를 숫자들
            if(number == 3 || number == 6 || number == 9) {
                sb.append("R");
                switch(number){
                    case 3: {
                        rightFinger.setRow(0);
                        rightFinger.setColumn(2);
                        break;
                    }
                    case 6: {
                        rightFinger.setRow(1);
                        rightFinger.setColumn(2);
                        break;
                    }
                    case 9: {
                        rightFinger.setRow(2);
                        rightFinger.setColumn(2);
                        break;
                    }
                }
                continue;
            }
            // 왼손으로 누를지 오른손으로 누를지 확인해야 할 얘들
            switch(number){
                case 2: {
                    numberLocation.setRow(0);
                    break;
                }
                case 5: {
                    numberLocation.setRow(1);
                    break;
                }
                case 8: {
                    numberLocation.setRow(2);
                    break;
                }
                case 0: {
                    numberLocation.setRow(3);
                    break;
                }
            }
            int rightLength = Math.abs(rightFinger.getRow() - numberLocation.getRow()) + Math.abs(rightFinger.getColumn() - numberLocation.getColumn());
            int leftLength = Math.abs(leftFinger.getRow() - numberLocation.getRow()) + Math.abs(leftFinger.getColumn() - numberLocation.getColumn());

            if(rightLength > leftLength) {
                setFingerPosition(number, leftFinger);
                sb.append("L");
            } else if(rightLength < leftLength){
                setFingerPosition(number, rightFinger);
                sb.append("R");
            } else{
                if(hand.equals("right")) {
                    setFingerPosition(number, rightFinger);
                    sb.append("R");
                } else {
                    setFingerPosition(number, leftFinger);
                    sb.append("L");
                }
            }

        }
        return sb.toString();
    }

    private void setFingerPosition(int number, Finger leftFinger) {
        switch(number){
            case 2: {
                leftFinger.setRow(0);
                leftFinger.setColumn(1);
                break;
            }
            case 5: {
                leftFinger.setRow(1);
                leftFinger.setColumn(1);
                break;
            }
            case 8: {
                leftFinger.setRow(2);
                leftFinger.setColumn(1);
                break;
            }
            case 0: {
                leftFinger.setRow(3);
                leftFinger.setColumn(1);
                break;
            }
        }
    }
}