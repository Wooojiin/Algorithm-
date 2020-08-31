package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 음식물 피하기

public class Solution1743 {
    static int isize, jsize, number, max;
    static boolean[][] map, visit;
    static Queue<Point> queue;

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().trim().split(" ");
        isize = Integer.parseInt(size[0]);
        jsize = Integer.parseInt(size[1]);
        number = Integer.parseInt(size[2]);

        map = new boolean[isize][jsize];
        visit = new boolean[isize][jsize];

        queue = new LinkedList<>();

        for (int i = 0; i < number; i++) {
            String[] input = br.readLine().trim().split(" ");

            int nowi = Integer.parseInt(input[0]) - 1;
            int nowj = Integer.parseInt(input[1]) - 1;

            map[nowi][nowj] = true;
        }

        max = 0;
        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {
                if(map[i][j]){
                    queue.add(new Point(i, j));
                    bfs();
                }
            }
        }
        System.out.println(max);
    }

    static void bfs(){
        int count = 0;

        while(!queue.isEmpty()){
            Point now = queue.poll();
            count++;

            visit[now.i][now.j] = true;

            for (int d = 0; d < 4; d++) {
                int nexti = now.i + di[d];
                int nextj = now.j + dj[d];

                if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && map[nexti][nextj] && !visit[nexti][nextj]){
                    visit[nexti][nextj] = true;
                    queue.add(new Point(nexti, nextj));
                }
            }
        }
        max = Integer.max(max, count);
    }

    static class Point{
        int i, j;

        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
