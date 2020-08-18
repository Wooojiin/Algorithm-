package swexpert;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 오! 나의 여신님

public class Solution7793 {
    static int isize, jsize, time;
    static char[][] map;

    static Queue<Position> move, devil;

    static int[] di = {-1, 1, 0 ,0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= testCase; tc++) {
            String[] size = br.readLine().trim().split(" ");

            isize = Integer.parseInt(size[0]);
            jsize = Integer.parseInt(size[1]);

            map = new char[isize][jsize];

            move = new LinkedList<>();
            devil = new LinkedList<>();

            for (int i = 0; i < isize; i++) {
                map[i] = br.readLine().trim().toCharArray();
                for (int j = 0; j < jsize; j++) {
                    if(map[i][j] == '*'){
                        devil.add(new Position(i, j, 0));
                    }else if(map[i][j] == 'S'){
                        move.add(new Position(i, j, 0));
                    }
                }
            }
            time = 0;

            find();

            bw.write("#" + tc + " ");
            if(time == 0){
                bw.write("GAME OVER");
            }else{
                bw.write(time +"");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void find(){

        while(!move.isEmpty()){

            int devilNum = devil.size();

            for (int i = 0; i < devilNum; i++) {
                Position now = devil.poll();

                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];

                    if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] == '.'){
                        map[nexti][nextj] = '*';
                        devil.add(new Position(nexti, nextj, 0));
                    }
                }
            }// 영역 확장

            int moveNum = move.size();

            for (int i = 0; i < moveNum; i++) {
                Position now = move.poll();

                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];

                    if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize){
                        if(map[nexti][nextj] == 'D'){
                            time = now.value + 1;
                            return;
                        }else if(map[nexti][nextj] == '.'){
                            move.add(new Position(nexti, nextj, now.value + 1));
                            map[nexti][nextj] = 'S';
                        }
                    }
                }
            }
        }
    }


    static class Position{
        int i, j, value;

        Position(int i, int j, int value){
            this.i = i;
            this.j = j;
            this.value = value;
        }
    }
}
