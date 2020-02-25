package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1012 {
    static int isize, jsize;
    static int[][] map;

    static int[] di = {0,0,-1,1};
    static int[] dj = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            String[] input = br.readLine().split(" ");

            isize = Integer.parseInt(input[0]);
            jsize = Integer.parseInt(input[1]);
            int inNum = Integer.parseInt(input[2]);

            map = new int[isize][jsize];

            for (int i = 0; i < inNum; i++) {
                String[] position = br.readLine().split(" ");
                int posI = Integer.parseInt(position[0]);
                int posJ = Integer.parseInt(position[1]);

                map[posI][posJ] = 1;
            }
            int count = 0;

            for (int i = 0; i < isize; i++) {
                for (int j = 0; j < jsize; j++) {
                    if(map[i][j] == 1){
                        count++;
                        find(i,j);
                    }
                }
            }

            System.out.println(count);
        }
    }

    public static void find(int i, int j){
        map[i][j] = 2; //visit

        for (int d = 0; d < 4; d++) {
            int nexti = i + di[d];
            int nextj = j + dj[d];

            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] == 1){
                find(nexti,nextj);
            }
        }
    }
}
