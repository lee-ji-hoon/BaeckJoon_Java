package programmers.kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 우선 제한 사항에서 room_number 배열의 크기가 1~200,000 이하 인 것을 보고
 * 완전탐색으로 풀게 될 경우 효율성이 너무 떨어져서 재귀를 하는 방법을 선택했습니다.
 *
 * 고객이 원하는 방 즉 room 이 빈 방인지 아닌지 체크부터 진행합니다.
 *
 * 1. 빈 방일경우 고객에게 배정하고, 배정된 방 번호를 Map<배정된 번호, 그 다음 번호>로 지정한 뒤
 *  1-1.현재 room값을 반환했습니다.
 * 2.만약 빈방이 아닌 경우 다시 재귀로 탐색을 합니다.
 * 3.앞서서 방문했던 비어 있지 않은 방에 대해서 다음 비어있는 방을 연결해주었습니다.
 */
class Kakao_2019_호텔_방_예약 {
    Map<Long, Long> roomsNumber = new HashMap<>();

    private long findRoomNumber(long room) {
        // 현재 고객이 원하는 방이 비어있을 경우
        if (!roomsNumber.containsKey(room)) {
            roomsNumber.put(room, room + 1); // 현재 방 번호와 그 다음 번호를 저장
            return room; // 배정했다는 의미로 room값 반환
        }
        // 방이 이미 주인이 있을 경우
        // 빈 방이 나올 때까지 부모 노드를 계속 방문
        long emptyRoom = findRoomNumber(roomsNumber.get(room));

        // 현재 room 값과 비어있던 방을 추가
        roomsNumber.put(room, emptyRoom);
        // 빈 방이 이제는 채워졌으므로 결과값에 추가
        return emptyRoom;
    }

    // k는 없어도 되는데 입출력 예시에 있기에 넣었습니다.
    public long[] solution(long k, long[] room_number) {
        // findEmptyRoom 에서 반한되는 값들 다시 배열로 만든 후 값 반환
        return Arrays.stream(room_number)
                .map(this::findRoomNumber)
                .distinct()
                .toArray();
    }
}