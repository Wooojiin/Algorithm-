package baekjoon;

import java.io.*;

// 1, 2, 3 더하기

public class Solution9095 {
    static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < testCase; tc++) {
            int num = Integer.parseInt(br.readLine().trim());
            memo = new int[num + 1];

            bw.write(find(num) + "");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int find(int now){
        if(now == 1) return 1;
        if(now == 2) return 2;
        if(now == 3) return 4;

        if(memo[now] > 0) return memo[now];

        memo[now] = find(now - 1) + find(now - 2) + find(now - 3);

        return memo[now];
    }
}
