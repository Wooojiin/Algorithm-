package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 로봇 청소기

public class Solution14503 {
    static int isize, jsize;
    static int[][] map;
    static int count;

    static int[] di = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dj = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().trim().split(" ");
        isize = Integer.parseInt(size[0]);
        jsize = Integer.parseInt(size[1]);

        map = new int[isize][jsize];

        Queue<Position> queue = new LinkedList<>();

        String[] start = br.readLine().trim().split(" ");
        queue.add(new Position(Integer.parseInt(start[0]), Integer.parseInt(start[1]), Integer.parseInt(start[2])));

        for (int i = 0; i < isize; i++) {
            String[] input = br.readLine().trim().split(" ");
            for (int j = 0; j < jsize; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        count = 0;

        while (!queue.isEmpty()){
            Position now = queue.poll();

            if(map[now.i][now.j] == 0){ // 청소안한곳이면
                map[now.i][now.j] = 2;
                count++;
            }

            int nextDir = now.dir;
            boolean find = false;

            for (int turn = 0; turn < 4; turn++) {
                nextDir = (nextDir + 3) % 4;

                int nexti = now.i + di[nextDir];
                int nextj = now.j + dj[nextDir];

                if(map[nexti][nextj] == 0){
                    find = true;
                    queue.add(new Position(nexti, nextj, nextDir));
                    break;
                }
            }
            boolean end = false;

            if(!find){  // 모두 청소 or 벽
                if(now.dir >= 2){
                    nextDir = now.dir - 2;
                }else{
                    nextDir = now.dir + 2;
                }

                int nexti = now.i + di[nextDir];
                int nextj = now.j + dj[nextDir];

                if(map[nexti][nextj] != 1){
                    queue.add(new Position(nexti, nextj, now.dir));
                }else{
                    end = true;
                }
            }

            if(end)
                break;
        }
        System.out.println(count);


    }

    static class Position{
        int i,j,dir;

        Position(int i, int j , int dir){
            this.i = i;
            this.j = j;
            this.dir = dir;
        }
    }
}
