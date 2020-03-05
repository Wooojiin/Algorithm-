package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1926 {
    static int isize, jsize, maxSize, sizeCount, count;
    static int[][] map;

    static int[] di = {0,0,-1,1};
    static int[] dj = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        isize = Integer.parseInt(size[0]);
        jsize = Integer.parseInt(size[1]);

        map = new int[isize][jsize];

        for (int i = 0; i < isize; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < jsize; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        count = 0;
        maxSize = 0;
        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                if(map[i][j] == 1){
                    count++;
                    sizeCount = 0;

                    find(i,j);
                    if(maxSize < sizeCount)
                        maxSize = sizeCount;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }

    static void find(int nowi, int nowj){
        sizeCount++;
        map[nowi][nowj] = 0;

        for (int d = 0; d < 4; d++) {
            int nexti = nowi + di[d];
            int nextj = nowj + dj[d];

            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] == 1){
                find(nexti,nextj);
            }
        }
    }
}
