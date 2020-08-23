package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 불!

public class Solution4179 {
    static int isize, jsize, min;
    static char[][] map;
    static Queue<Position> move, fire;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] size = br.readLine().trim().split(" ");

        isize = Integer.parseInt(size[0]);
        jsize = Integer.parseInt(size[1]);

        map = new char[isize][jsize];
        move = new LinkedList<>();
        fire = new LinkedList<>();

        for (int i = 0; i < isize; i++) {
            map[i] = br.readLine().trim().toCharArray();
            for (int j = 0; j < jsize; j++) {
                char now = map[i][j];

                if(now == 'J'){
                    move.add(new Position(i, j, 0));
                }else if(now == 'F'){
                    fire.add(new Position(i, j, 0));
                }
            }
        }

        min = Integer.MAX_VALUE;
        find();

        if(min == Integer.MAX_VALUE)
            System.out.println("IMPOSSIBLE");
        else
            System.out.println(min + "");

    }

    static void find(){

        while(!move.isEmpty()){

            int fireNum = fire.size();

            for (int i = 0; i < fireNum; i++) {
                Position now = fire.poll();

                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];

                    if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] == '.'){
                        map[nexti][nextj] = 'F';
                        fire.add(new Position(nexti, nextj, 0));
                    }
                }
            }// fire spread

            int moveNum = move.size();

            for (int i = 0; i < moveNum; i++) {
               Position now = move.poll();
                int distance = now.distance;

                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];

                    if(nexti < 0 || nexti >= isize || nextj < 0 || nextj >= jsize){
                        min = distance + 1;
                        return;
                    }else if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] == '.'){
                        map[nexti][nextj] = 'J';
                        move.add(new Position(nexti, nextj , distance + 1));
                    }
                }
            }
        }
    }

    static class Position{
        int i, j, distance;

        Position(int i, int j, int distance){
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }
}
