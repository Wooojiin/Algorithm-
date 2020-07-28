package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2589 {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().trim().split(" ");

        int isize = Integer.parseInt(size[0]);
        int jsize = Integer.parseInt(size[1]);

        char[][] map = new char[isize][jsize];

        for (int i = 0; i < isize; i++) {
            map[i] = br.readLine().trim().toCharArray();
        }

        Queue<Land> queue = new LinkedList<>();

        int maxDistance = 0;

        for (int i = 0; i < isize; i++) {
            for (int j = 0; j < jsize; j++) {

                if(map[i][j] == 'L'){
                    boolean[][] visit = new boolean[isize][jsize];
                    queue.add(new Land(i, j, 0));

                    while(!queue.isEmpty()){
                        Land now = queue.poll();
                        visit[now.i][now.j] = true;

                        maxDistance = Integer.max(maxDistance, now.distance);

                        for (int d = 0; d < 4; d++) {
                            int nexti = now.i + di[d];
                            int nextj = now.j + dj[d];

                            if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && !visit[nexti][nextj] && map[nexti][nextj] == 'L'){
                                queue.add(new Land(nexti, nextj, now.distance + 1));
                                visit[nexti][nextj] = true;
                            }
                        }

                    }

                }
            }
        }
        System.out.println(maxDistance);
    }

    static class Land{
        int i, j, distance;

        Land(int i, int j, int distance){
            this.i = i;
            this.j = j;
            this.distance = distance;
        }
    }
}
