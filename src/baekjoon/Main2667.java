package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main2667 {
    static int[][] map;
    static int size, groupNum, houseNum;
    static int[] di = {0,0,1,-1};
    static int[] dj = {1,-1,0,0};
    static LinkedList<Integer> group;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split("");

            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        groupNum = 1;

        boolean[][] visit = new boolean[size][size];
        Queue<Point> que = new LinkedList<>();

        group = new LinkedList<>();
        groupNum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(map[i][j] != 0 && !visit[i][j]){
                    groupNum++;
                    houseNum = 1;
                    que.add(new Point(i,j));
                    visit[i][j] = true;

                    while(!que.isEmpty()){
                        Point now = que.poll();
                        for (int d = 0; d < 4; d++) {
                            int nexti = now.i + di[d];
                            int nextj = now.j + dj[d];

                            if(nexti >= 0 && nexti < size && nextj >= 0 && nextj < size && map[nexti][nextj] != 0 && !visit[nexti][nextj]){
                                visit[nexti][nextj] = true;
                                que.add(new Point(nexti, nextj));
                                houseNum++;
                            }
                        }
                    }
                    group.add(houseNum);
                }
            }
        }
        Collections.sort(group);
        System.out.println(groupNum);
        for (int i = 0; i < groupNum; i++) {
            System.out.println(group.get(i));
        }
    }

    public static class Point{
        int i;
        int j;

        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
