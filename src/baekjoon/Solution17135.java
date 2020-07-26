package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution17135 {
    static int isize, jsize, limitDistance;
    static int[][] map, now;
    static boolean[][] visit, kill;
    static boolean[] used;
    static int count, maxCount;

    static LinkedList<Integer> archerList;

    static int[] di = {0, -1, 0};
    static int[] dj = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().trim().split(" ");

        isize = Integer.parseInt(size[0]);
        jsize = Integer.parseInt(size[1]);
        limitDistance = Integer.parseInt(size[2]);

        map = new int[isize + 1][jsize];    // 제일 아래 궁수
        now = new int[isize + 1][jsize];

        for (int i = 0; i < isize; i++) {
            String[] input = br.readLine().trim().split(" ");
            for (int j = 0; j < jsize; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        maxCount = 0;
        used = new boolean[jsize];

        archerList = new LinkedList<>();
        arrange(0, 0);

        System.out.println(maxCount);

    }
    static void arrange(int nowNumber, int start){
        if(nowNumber == 3){ // 배치 완료
            init();
            count = 0;
            kill = new boolean[isize][jsize];

            for (int i = 0; i < isize; i++) {   // 모든 턴 진행
                for (int archer : archerList) {
                    now[isize][archer] = 2;

                    PriorityQueue<Position> pq = new PriorityQueue<>();
                    visit = new boolean[isize + 1][jsize];

                    pq.add(new Position(isize, archer, 0));

                    while(!pq.isEmpty()){
                        Position pos = pq.poll();

                        visit[pos.i][pos.j] = true;

                        if(pos.distance > limitDistance){
                            break;
                        }

                        if(now[pos.i][pos.j] == 1){ // 적일 경우
                            kill[pos.i][pos.j] = true;
                            break;  // 가장 가까운 적만 처치
                        }


                        for (int d = 0; d < 3; d++) {
                            int nexti = pos.i + di[d];
                            int nextj = pos.j + dj[d];

                            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && !visit[nexti][nextj]){
                                pq.add(new Position(nexti, nextj, pos.distance + 1));
                            }
                        }
                    }
                }// 죽일 것들 다 체크함
                count += kill();
                move();
            }

            maxCount = Integer.max(maxCount, count);

            return;
        }

        for (int j = start; j < jsize; j++) {
            if(!used[j]){
                used[j] = true;
                archerList.add(j);
                arrange(nowNumber + 1, start + 1);
                used[j] = false;
                archerList.removeLast();
            }
        }
    }

    static int kill(){
        int killCount = 0;
        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                if(kill[i][j]){
                    killCount++;
                    now[i][j] = 0;
                    kill[i][j] = false;
                }
            }
        }
        return killCount;
    }

    static void move(){
        for (int i = isize - 1; i >= 1; i--) {
            for (int j = 0; j < jsize; j++) {
                now[i][j] = now[i - 1][j];
            }
        }
        Arrays.fill(now[0], 0);
    }

    static void init(){
        for (int i = 0; i <= isize; i++) {
            for (int j = 0; j < jsize; j++) {
                now[i][j] = map[i][j];
            }
        }
    }

    static void print(){
        for (int i = 0; i <= isize; i++) {
            for (int j = 0; j < jsize; j++) {
                System.out.print(now[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void killPrint(){
        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                System.out.print(kill[i][j] + " ");
            }
            System.out.println();
        }
    }

    static class Position implements Comparable<Position>{
        int i, j, distance;

        Position(int i, int j, int distance){
            this.i = i;
            this.j = j;
            this.distance = distance;
        }

        @Override
        public int compareTo(Position o) {
            if(this.distance == o.distance)
                return this.j - o.j;
            return this.distance - o.distance;
        }
    }
}
