package swexpert;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 밍이의 블록게임

public class Solution4740 {
    static int isize, jsize, stepNum;
    static char[][] map;
    static char[] upArray;
    static boolean[][] visit;

    static PriorityQueue<Position> pq;
    static Queue<Position> queue;
    static Queue<Character> moveQueue;

    static int[] di = {-1, 1, 0 ,0};
    static int[] dj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= testCase; tc++) {
            String[] size = br.readLine().trim().split(" ");

            isize = Integer.parseInt(size[0]);
            jsize = Integer.parseInt(size[1]);
            stepNum = Integer.parseInt(size[2]);

            map = new char[isize][jsize];

            for (int i = 0; i < isize; i++) {
                map[i] = br.readLine().trim().toCharArray();
            }

            queue = new LinkedList<>();
            pq = new PriorityQueue<>();
            moveQueue = new LinkedList<>();

            for (int s = 0; s < stepNum; s++) {
                String[] step = br.readLine().trim().split(" ");

                char button = step[0].charAt(0);

                if(button == 'L'){
                    left();
                }else if(button == 'R'){
                    right();
                }else if(button == 'D'){
                    down();
                }else{
                    upArray = step[1].toCharArray();
                    up();
                }
            }
            bw.write("#" + tc);
            bw.newLine();

            for (int i = 0; i < isize; i++) {
                sb.setLength(0);
                for (int j = 0; j < jsize; j++) {
                    sb.append(map[i][j]);
                }
                bw.write(sb.toString());
                bw.newLine();
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void left(){
        moveQueue.clear();

        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                char now = map[i][j];
                if(now != '#'){
                    moveQueue.add(now);
                    map[i][j] = '#';
                }
            }

            int queueSize = moveQueue.size();
            for (int m = 0; m < queueSize; m++) {
                map[i][m] = moveQueue.poll();
            }
        }
    }

    static void right(){
        moveQueue.clear();

        for (int i = 0; i < isize; i++) {
            for (int j = jsize - 1; j >= 0; j--) {
                char now = map[i][j];
                if(now != '#'){
                    moveQueue.add(now);
                    map[i][j] = '#';
                }
            }

            int queueSize = moveQueue.size();
            for (int m = 0; m < queueSize; m++) {
                map[i][jsize - 1 - m] = moveQueue.poll();
            }
        }
    }

    static void up(){
        boolean possible = true;

        for (int j = 0; j < jsize; j++) {
            if(map[0][j] != '#'){
                possible = false;
            }
        }

        if(possible){
            moveQueue.clear();

            for (int j = 0; j < jsize; j++) {
                for (int i = isize - 1; i >= 0; i--) {
                    char now = map[i][j];
                    if(now != '#'){
                        moveQueue.add(now);
                        map[i][j] = '#';
                    }
                }
                int queueSize = moveQueue.size();
                for (int m = 0; m < queueSize; m++) {
                    map[isize - 2 - m][j] = moveQueue.poll();
                }
            }

            for (int j = 0; j < jsize; j++) {
                char in = upArray[j];
                if(in == '#'){
                    moveQueue.clear();

                    for (int i = isize - 2; i >= 0; i--) {
                        char now = map[i][j];
                        if(now != '#'){
                            moveQueue.add(now);
                            map[i][j] = '#';
                        }
                    }
                    int queueSize = moveQueue.size();
                    for (int m = 0; m < queueSize; m++) {
                        map[isize - 1 - m][j] = moveQueue.poll();
                    }
                }else{
                    map[isize - 1][j] = in;
                }
            }
        }
    }

    static void down(){
        pq.clear();
        queue.clear();

        visit = new boolean[isize][jsize];

        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                if(map[i][j] != '#' && !visit[i][j]){
                    queue.add(new Position(i, j, 1));

                    int size = 0;

                    while(!queue.isEmpty()){
                        Position now = queue.poll();
                        visit[now.i][now.j] = true;
                        char color = map[now.i][now.j];
                        size++;

                        for (int d = 0; d < 4; d++) {
                            int nexti = now.i + di[d];
                            int nextj = now.j + dj[d];

                            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && !visit[nexti][nextj] && map[nexti][nextj] == color){
                                visit[nexti][nextj] = true;
                                queue.add(new Position(nexti, nextj, size));
                            }
                        }
                    }
                    pq.add(new Position(i, j , size));
                }
            }
        }

        int max = pq.isEmpty() ? 0 : pq.peek().size;

        while(!pq.isEmpty() && pq.peek().size == max){
            Position delete = pq.poll();
            queue.clear();
            queue.add(new Position(delete.i, delete.j, 0));
            char color = map[delete.i][delete.j];

            while(!queue.isEmpty()){
                Position now = queue.poll();
                map[now.i][now.j] = '#';

                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];

                    if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] == color){
                        map[nexti][nextj] = '#';
                        queue.add(new Position(nexti, nextj, 0));
                    }
                }
            }
        }

        moveQueue.clear();

        for (int j = 0; j < jsize; j++) {
            for (int i = isize - 1; i >= 0; i--) {
                char now = map[i][j];
                if(now != '#'){
                    moveQueue.add(now);
                    map[i][j] = '#';
                }
            }

            int queueSize = moveQueue.size();
            for (int m = 0; m < queueSize; m++) {
                map[isize - 1 - m][j] = moveQueue.poll();
            }
        }
    }

    static class Position implements Comparable<Position>{
        int i, j, size;

        Position(int i, int j, int size){
            this.i = i;
            this.j = j;
            this.size = size;
        }

        @Override
        public int compareTo(Position o) {
            return o.size - this.size;
        }
    }
}
