package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 연구소

public class Solution14502 {
    static int isize, jsize, max;
    static int[][] map, use;
    static boolean[][] visit, select;

    static LinkedList<Position> wallList;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().trim().split(" ");

        isize = Integer.parseInt(size[0]);
        jsize = Integer.parseInt(size[1]);

        map = new int[isize][jsize];
        use = new int[isize][jsize];

        for (int i = 0; i < isize; i++) {
            String[] input = br.readLine().trim().split(" ");
            for (int j = 0; j < jsize; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        select = new boolean[isize][jsize];
        wallList = new LinkedList<>();
        max = 0;

        selectWall(0, 0 ,0);

        System.out.println(max);
    }

    static void selectWall(int ni, int nj, int count){
        if(count == 3){
            init();

            for (Position wall : wallList) {
                use[wall.i][wall.j] = 1;
            }

            spread();

            max = Integer.max(max, calculateArea());

            return;
        }

        for (int i = ni; i < isize; i++) {
            for (int j = nj; j < jsize; j++) {
                if(map[i][j] == 0 && !select[i][j]){
                    select[i][j] = true;
                    wallList.add(new Position(i, j));
                    selectWall(i, j, count + 1);
                    select[i][j] = false;
                    wallList.removeLast();
                }
            }
            nj = 0;
        }
    }

    static void init(){
        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                use[i][j] = map[i][j];
            }
        }
    }

    static int calculateArea(){ // 안전영역 계산
        int count = 0;

        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                if(use[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }

    static void spread(){   // 바이러스 확산
        visit = new boolean[isize][jsize];

        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {

                if(use[i][j] == 2){
                    Queue<Position> queue = new LinkedList<>();
                    queue.add(new Position(i, j));

                    while(!queue.isEmpty()){
                        Position now = queue.poll();
                        visit[now.i][now.j] = true;

                        for (int d = 0; d < 4; d++) {
                            int nexti = now.i + di[d];
                            int nextj = now.j + dj[d];

                            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize  && use[nexti][nextj] == 0 && !visit[nexti][nextj]){
                                use[nexti][nextj] = 2;
                                queue.add(new Position(nexti, nextj));
                            }
                        }
                    }
                }
            }
        }
    }

    static class Position{
        int i, j;

        Position(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
