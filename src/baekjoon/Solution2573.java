package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 빙산

public class Solution2573 {

    static int isize, jsize;
    static int[][] map;
    static int[][] melt;
    static boolean[][] check;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().trim().split(" ");

        isize = Integer.parseInt(size[0]);
        jsize = Integer.parseInt(size[1]);

        map = new int[isize][jsize];
        melt = new int[isize][jsize];

        for (int i = 0; i < isize; i++) {
            String[] input = br.readLine().trim().split(" ");

            for (int j = 0; j < jsize; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int blockNum = 1;
        boolean nothing = false;
        int time = 0;

        while(blockNum == 1){

            for (int i = 1; i < isize - 1; i++) {
                for (int j = 1; j < jsize - 1; j++) {
                    if(map[i][j] != 0){
                        melt(i, j);
                    }
                }
            }

            for (int i = 1; i < isize - 1; i++) {
                for (int j = 1; j < jsize - 1; j++) {
                    if(melt[i][j] != 0){
                        map[i][j] -= melt[i][j];
                        if(map[i][j] < 0)
                            map[i][j] = 0;

                        melt[i][j] = 0;
                    }
                }
            }

            if(meltedAll()){
                nothing = true;
                break;
            }
            time++;

            blockNum = count();
        }
        if(nothing)
            System.out.println(0);
        else
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

    static void melt(int nowi, int nowj){ // 녹을 양 계산

        for (int d = 0; d < 4; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] == 0){
                melt[nowi][nowj]++;
            }
        }
    }

    static int count(){ // 덩어리 갯수 반환
        int res = 0;

        check = new boolean[isize][jsize];

        for (int i = 1; i < isize - 1; i++) {
            for (int j = 1; j < jsize - 1; j++) {
                if(map[i][j] != 0 && !check[i][j]){
                    res++;
                    block(i, j);
                }
            }
        }
        return res;
    }

    static void block(int nowi, int nowj){
        check[nowi][nowj] = true;

        for (int d = 0; d < 4; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] != 0 && !check[nexti][nextj]){
                check[nexti][nextj] = true;
                block(nexti, nextj);
            }
        }
    }

    static boolean meltedAll(){ // 다 녹았는지 확인
        for (int i = 1; i < isize - 1; i++) {
            for (int j = 1; j < jsize - 1; j++) {
                if(map[i][j] != 0)
                    return false;   // 덜 녹음
            }
        }
        return true;    // 다 녹음
    }
}
