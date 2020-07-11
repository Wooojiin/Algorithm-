package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 미세먼지 안녕!

public class Solution17144 {
    static int isize, jsize, time;
    static int upI, downI; // 공기청정기 무조건 1열

    static int[][] map;
    static int[][] moveDust;

    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().trim().split(" ");

        isize = Integer.parseInt(input[0]);
        jsize = Integer.parseInt(input[1]);
        time = Integer.parseInt(input[2]);

        map = new int[isize][jsize];
        moveDust = new int[isize][jsize]; // 이동예정 미세먼지 양

        for (int i = 0; i < isize; i++) {
            String[] line = br.readLine().trim().split(" ");

            for (int j = 0; j < jsize; j++) {
                map[i][j] = Integer.parseInt(line[j]);

                if(map[i][j] == -1){
                    downI = i;
                }
                upI = downI - 1;
            }
        }

        while(time > 0){

            for (int i = 0; i < isize; i++) {
                for (int j = 0; j < jsize; j++) {
                    if(map[i][j] >= 5){
                        move(i, j);
                    }
                }
            }

            // 여기서 move 배열 기존 map에 반영 필요
            for (int i = 0; i < isize; i++) {
                for (int j = 0; j < jsize; j++) {
                    if(moveDust[i][j] != 0){
                        map[i][j] += moveDust[i][j];
                        moveDust[i][j] = 0;
                    }
                }
            }

            // 공청기 작동
            up();
            down();

            time--;
        }
        System.out.println(sum());
    }

    static void print(){
        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void move(int nowi, int nowj){
        int dust = map[nowi][nowj];

        for (int d = 0; d < 4; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] != -1){
                moveDust[nexti][nextj] += (dust / 5);
                moveDust[nowi][nowj] -= (dust / 5);
            }
        }
    }

    // 위쪽 공청기
    static void up(){
        int tmp1 = map[upI][jsize - 1];

        for (int j = jsize - 1; j > 1; j--) {  // >
            map[upI][j] = map[upI][j - 1];
        }
        map[upI][1] = 0;

        int tmp2 = map[0][jsize - 1];

        for (int i = 0; i < upI - 1; i++) {   // ^
            map[i][jsize - 1] = map[i + 1][jsize - 1];
        }
        map[upI - 1][jsize - 1] = tmp1;

        int tmp3 = map[0][0];

        for (int j = 0; j < jsize - 2; j++) {   // <
            map[0][j] = map[0][j + 1];
        }
        map[0][jsize - 2] = tmp2;

        for (int i = upI - 1; i > 0 ; i--) {    // v
            map[i][0] = map[i - 1][0];
        }
        map[1][0] = tmp3;
    }

    // 아래쪽 공청기
    static void down(){
        int tmp1 = map[downI][jsize - 1];

        for (int j = jsize - 1; j > 1; j--) {  // >
            map[downI][j] = map[downI][j - 1];
        }
        map[downI][1] = 0;

        int tmp2 = map[isize - 1][jsize - 1];

        for (int i = isize - 1; i > downI + 1; i--) {   // v
            map[i][jsize - 1] = map[i - 1][jsize - 1];
        }
        map[downI + 1][jsize - 1] = tmp1;

        int tmp3 = map[isize - 1][0];

        for (int j = 0; j < jsize - 2; j++) {   // <
            map[isize - 1][j] = map[isize - 1][j + 1];
        }
        map[isize - 1][jsize - 2] = tmp2;

        for (int i = downI + 1; i < isize - 1 ; i++) {    // ^
            map[i][0] = map[i + 1][0];
        }
        map[isize - 2][0] = tmp3;
    }


    static int sum(){
        int res = 0;

        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                if(map[i][j] != 0 && map[i][j] != -1){
                    res += map[i][j];
                }
            }
        }
        return res;
    }
}
