package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 타일 채우기

public class Solution2133 {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        memo = new int[size + 1];

        System.out.println(find(size));
    }

    static int find(int now){
        if(now == 0) return 1;

        if(now == 1) return 0;

        if(now == 2) return 3;

        if(memo[now] != 0) return memo[now];

        int result = 3 * find(now - 2);
        for (int i = 3; i <= now; i++) {
            if(i % 2 == 0){
                result += 2 * find(now - i);
            }
        }
        memo[now] = result;
        return result;
    }
}
