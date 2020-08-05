package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2178 {
    static int isize, jsize;
    static int[][] map;
    static boolean[][] chk;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        isize = Integer.parseInt(line[0]);
        jsize = Integer.parseInt(line[1]);

        map = new int[isize][jsize];
        chk = new boolean[isize][jsize];

        Queue<Pos> que = new LinkedList<>();

        for (int i = 0; i < isize; i++) {
            String str = br.readLine();
            for (int j = 0; j < jsize; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        que.add(new Pos(0, 0));

        int val = 0;
        while(!que.isEmpty()) {

            Pos now = que.poll();
            chk[now.i][now.j] = true;

            val = map[now.i][now.j];

            if(now.i == isize - 1 && now.j == jsize - 1) {
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nexti = now.i + di[d];
                int nextj = now.j + dj[d];

                if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && !chk[nexti][nextj] && map[nexti][nextj] != 0) {
                    map[nexti][nextj] = val + 1;
                    que.add(new Pos(nexti, nextj));
                    chk[nexti][nextj] = true;
                }
            }
        }
        System.out.println(val);
    }

    static class Pos{
        int i, j;

        Pos(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
