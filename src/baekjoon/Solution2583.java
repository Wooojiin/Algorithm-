package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

// 영역 구하기

public class Solution2583 {
    static int[][] map;
    static int isize, jsize;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] size = br.readLine().trim().split(" ");
        isize = Integer.parseInt(size[0]);
        jsize = Integer.parseInt(size[1]);

        map = new int[isize][jsize];

        int num = Integer.parseInt(size[2]);

        for (int n = 0; n < num; n++) {
            String[] input = br.readLine().trim().split(" ");

            int startj = Integer.parseInt(input[0]);
            int starti = Integer.parseInt(input[1]);

            int endj = Integer.parseInt(input[2]);
            int endi = Integer.parseInt(input[3]);

            for (int i = starti; i < endi; i++) {
                for (int j = startj; j < endj; j++) {
                    map[i][j] = 1;
                }
            }
        }

        LinkedList<Integer> res = new LinkedList<>();

        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                if(map[i][j] == 0) {
                    cnt = 0;
                    find(i,j);
                    res.add(cnt);
                }
            }
        }
        Collections.sort(res);

        System.out.println(res.size());
        for (Integer number : res) {
            sb.append(number + " ");
        }
        System.out.println(sb.toString());
    }

    static void find(int nowi, int nowj) {
        map[nowi][nowj] = 1;
        cnt++;

        for (int d = 0; d < 4; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] == 0) {
                find(nexti, nextj);
            }
        }
    }
}
