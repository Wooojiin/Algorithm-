package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 현수막

public class Solution14716 {
    static int isize, jsize;
    static int[][] map;

    static int[] di = {-1,1,0,0,-1,-1,1,1};
    static int[] dj = {0,0,-1,1,-1,1,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().trim().split(" ");

        isize = Integer.parseInt(size[0]);
        jsize = Integer.parseInt(size[1]);

        map = new int[isize][jsize];

        for (int i = 0; i < isize; i++) {
            String[] input = br.readLine().trim().split(" ");

            for (int j = 0; j < jsize; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int count = 0;

        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                if(map[i][j] == 1){
                    count++;
                    find(i, j);
                }
            }
        }
        System.out.println(count);

    }

    static void find(int nowi, int nowj){
        map[nowi][nowj] = 2;

        for (int d = 0; d < 8; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] == 1){
                find(nexti, nextj);
            }
        }
    }
}
