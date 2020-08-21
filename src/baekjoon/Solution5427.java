package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 불

public class Solution5427 {
    static int isize, jsize, min;
    static char[][] map;
    static Queue<Position> move, fire;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < testCase; tc++) {
            String[] size = br.readLine().trim().split(" ");

            isize = Integer.parseInt(size[1]);
            jsize = Integer.parseInt(size[0]);

            map = new char[isize][jsize];
            move = new LinkedList<>();
            fire = new LinkedList<>();

            for (int i = 0; i < isize; i++) {
                map[i] = br.readLine().trim().toCharArray();
                for (int j = 0; j < jsize; j++) {
                    char now = map[i][j];

                    if(now == '@'){
                        move.add(new Position(i, j, 0));
                    }else if(now == '*'){
                        fire.add(new Position(i, j, 0));
                    }
                }
            }

            min = Integer.MAX_VALUE;
            find();

            if(min == Integer.MAX_VALUE)
                bw.write("IMPOSSIBLE");
            else
                bw.write(min + "");

            bw.newLine();
        }

        bw.flush();
        bw.close();
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
                        map[nexti][nextj] = '*';
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
                        map[nexti][nextj] = '@';
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
