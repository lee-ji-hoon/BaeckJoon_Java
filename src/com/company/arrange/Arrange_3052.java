package com.company.arrange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Arrange_3052 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> hashSet = new HashSet<Integer>();

        for (int i = 0; i < 10; i++) {
            hashSet.add(Integer.parseInt(br.readLine()) % 42); // add(값) 값이 중복된게 없으면 추가해주고 내부에 값이 존재하지 않는다면 false 반환
        }
        System.out.print(hashSet.size()); // 나머지 값들을 알고 싶은게 아닌 나머지 값의 수량을 알고 싶은거라서 size()로 출력
    }
}
