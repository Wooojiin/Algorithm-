package baekjoon;

import java.io.*;

// 종이의 개수

public class Solution1780 {
    static int size, plus, zero, minus;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = Integer.parseInt(br.readLine().trim());
        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().trim().split(" ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        minus = zero = plus = 0;

        find(0, 0, size);

        bw.write(minus + "");
        bw.newLine();
        bw.write(zero + "");
        bw.newLine();
        bw.write(plus + "");
        bw.newLine();

        bw.flush();
        bw.close();
    }

    static void find(int starti, int startj, int nowSize){
        if(nowSize == 1 || check(starti, startj, nowSize)){
            int color = map[starti][startj];

            if(color == -1){
                minus++;
            }else if(color == 0){
                zero++;
            }else{
                plus++;
            }

            return;
        }

        int nextSize = nowSize / 3;

        find(starti, startj, nextSize);
        find(starti, startj + nextSize, nextSize);
        find(starti, startj + nextSize * 2, nextSize);

        find(starti + nextSize, startj, nextSize);
        find(starti + nextSize, startj + nextSize, nextSize);
        find(starti + nextSize, startj + nextSize * 2, nextSize);

        find(starti + nextSize * 2, startj, nextSize);
        find(starti + nextSize * 2, startj + nextSize, nextSize);
        find(starti + nextSize * 2, startj + nextSize * 2, nextSize);
    }

    static boolean check(int starti, int startj, int nowSize){
        int color = map[starti][startj];
        int endi = starti + nowSize;
        int endj = startj + nowSize;

        for (int i = starti; i < endi; i++) {
            for (int j = startj; j < endj; j++) {
                if(color != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
