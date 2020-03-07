package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4963 {
    static int[] di = {-1,-1,-1,0,0,1,1,1};
    static int[] dj = {-1,0,1,-1,1,-1,0,1};

    static int[][] map;
    static int isize, jsize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] size = br.readLine().split(" ");

            isize = Integer.parseInt(size[1]);
            jsize = Integer.parseInt(size[0]);

            if(isize == 0 && jsize == 0)
                break;

            map = new int[isize][jsize];

            for (int i = 0; i < isize; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < jsize; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            int cnt = 0;
            for (int i = 0; i < isize; i++) {
                for (int j = 0; j < jsize; j++) {
                    if(map[i][j] != 0) {
                        cnt++;
                        find(i,j);
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void find(int nowi, int nowj) {
        map[nowi][nowj] = 0;

        for (int d = 0; d < 8; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];
            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] != 0) {
                find(nexti,nextj);
            }
        }
    }
}