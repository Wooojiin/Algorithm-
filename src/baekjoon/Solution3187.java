package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 양치기 꿍

public class Solution3187 {
    static int isize, jsize;
    static char[][] map;
    static boolean[][] chk;
    static int sheep, wolf;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        isize = Integer.parseInt(line[0]);
        jsize = Integer.parseInt(line[1]);

        map = new char[isize][jsize];
        chk = new boolean[isize][jsize];

        for (int i = 0; i < isize; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int resW = 0, resS = 0;

        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                if(map[i][j] != '#' && !chk[i][j]) {
                    wolf = 0;
                    sheep = 0;
                    find(i,j);
                    if(wolf >= sheep) {
                        resW += wolf;
                    }else {
                        resS += sheep;
                    }
                }
            }
        }
        System.out.println(resS + " " + resW);
    }

    static void find(int ni, int nj) {
        chk[ni][nj] = true;

        if(map[ni][nj] == 'v') {
            wolf++;
        }else if(map[ni][nj] == 'k') {
            sheep++;
        }

        for (int d = 0; d < 4; d++) {
            int nexti = ni + di[d];
            int nextj = nj + dj[d];

            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && !chk[nexti][nextj] && map[nexti][nextj] != '#') {
                find(nexti, nextj);
            }
        }
    }
}
