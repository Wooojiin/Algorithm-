package baekjoon;

import java.util.Scanner;

// 2 x n 타일링

public class Solution11726 {
    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        memo = new int[size + 1];

        System.out.println(find(size));
    }

    static int find(int now){
        if(now <= 2)
            return  now;

        if(memo[now] > 0)
            return memo[now];

        memo[now] = (find(now -1) + find(now -2)) % 10007;
        return memo[now ];
    }
}
