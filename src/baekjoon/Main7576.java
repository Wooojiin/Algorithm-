package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main7576 {
    static int[] di = {0,0,-1,1};
    static int[] dj = {-1,1,0,0};

    static int isize, jsize;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");

        isize = Integer.parseInt(size[1]);
        jsize = Integer.parseInt(size[0]);

        map = new int[isize][jsize];
        visit = new boolean[isize][jsize];

        Queue<Position> queue = new LinkedList<>();

        for (int i = 0; i < isize; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < jsize; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 1){
                    queue.add(new Position(i, j));
                }
            }
        }

        int day = 0;
        while (!queue.isEmpty()){
            Position now = queue.poll();
            visit[now.i][now.j] = true;

            for (int d = 0; d < 4; d++) {
                day = map[now.i][now.j];
                int nexti = now.i + di[d];
                int nextj = now.j + dj[d];

                if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] == 0 && !visit[nexti][nextj]){
                    map[nexti][nextj] = ++day;
                    queue.add(new Position(nexti, nextj));
                }
            }
        }

        if(check())
            System.out.println(day - 1);
        else
            System.out.println(-1);
    }

    static boolean check(){
        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                if(map[i][j] == 0){
                    return false;
                }
            }
        }
        return  true;
    }

    static class Position{
        int i, j, day;

        Position(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
