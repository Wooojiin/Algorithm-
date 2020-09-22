package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1로 만들기

public class Solution1463 {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        memo = new int[num + 1];

        System.out.println(find(num));
    }

    static int find(int num){
        for (int i = 2; i <= num; i++) {
            memo[i] = memo[i - 1] + 1;
            if(i % 2 == 0)
                memo[i] = Math.min(memo[i], memo[i / 2] + 1);
            if(i % 3 == 0)
                memo[i] = Math.min(memo[i], memo[i / 3] + 1);
        }

        return memo[num];
    }
}
