package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 방 번호

public class Solution1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] roomNumber = br.readLine().trim().toCharArray();

        int[] checkNumber = new int[10];

        int maxValue = 0;

        for (int i = 0; i < roomNumber.length; i++) {
            int now = roomNumber[i] - '0';
            checkNumber[now]++;
        }

        checkNumber[6] += checkNumber[9];
        checkNumber[6] = checkNumber[6] % 2 + checkNumber[6] / 2;   // 6,9

        for (int i = 0; i < 8; i++) {
            if(checkNumber[i] >= maxValue)
                maxValue = checkNumber[i];
        }

        System.out.println(maxValue);
    }
}
