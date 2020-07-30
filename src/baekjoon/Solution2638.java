package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 치즈

public class Solution2638 {
    static int isize, jsize;
    static int[][] map;
    static boolean[][] check;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

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

        airCheck(0,0);
        int time = 0;

        while(true){
            check = new boolean[isize][jsize];

            for (int i = 1; i < isize - 1; i++) {
                for (int j = 1; j < jsize - 1; j++) {
                    if(map[i][j] == 1){
                        melt(i, j);
                    }
                }
            }

            for (int i = 1; i < isize - 1; i++) {
                for (int j = 1; j < jsize - 1; j++) {
                    if(check[i][j]){
                        airCheck(i, j);
                    }
                }
            }

            time++;

            if(meltAll()){
                break;
            }
        }

        System.out.println(time);


    }

    static void print(){
        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void airCheck(int nowi, int nowj){
        map[nowi][nowj] = 2;

        for (int d = 0; d < 4; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] == 0){
                airCheck(nexti, nextj);
            }
        }
    }

    static void melt(int nowi, int nowj){
        int count = 0;

        for (int d = 0; d < 4; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(map[nexti][nextj] == 2){
                count++;
                if(count >= 2){
                    check[nowi][nowj] = true;
                    break;
                }
            }
        }
    }

    static boolean meltAll(){
        for (int i = 1; i < isize - 1; i++) {
            for (int j = 1; j < jsize - 1; j++) {
                if(map[i][j] == 1)
                    return false;
            }
        }
        return true;
    }
}
