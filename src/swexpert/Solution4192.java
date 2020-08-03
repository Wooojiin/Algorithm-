package swexpert;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4192 {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine().trim());

        for (int tc = 1; tc <= testCase; tc++) {
            int size = Integer.parseInt(br.readLine().trim());

            int[][] map = new int[size][size];
            boolean[][] visit = new boolean[size][size];

            for (int i = 0; i < size; i++) {
                String[] input = br.readLine().trim().split(" ");
                for (int j = 0; j < size; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            Queue<Position> queue = new LinkedList<>();

            String[] startStr = br.readLine().trim().split(" ");
            String[] endStr = br.readLine().trim().split(" ");

            queue.add(new Position(Integer.parseInt(startStr[0]),Integer.parseInt(startStr[1]),0));
            Position end = new Position(Integer.parseInt(endStr[0]),Integer.parseInt(endStr[1]),0);
            int time = -1;

            while (!queue.isEmpty()){
                Position now = queue.poll();
                visit[now.i][now.j] = true;

                if(now.i == end.i && now.j == end.j){
                    time = now.distance;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];

                    if(nexti >= 0 && nexti < size && nextj >= 0 && nextj < size && !visit[nexti][nextj] && map[nexti][nextj] == 0){
                        queue.add(new Position(nexti, nextj, now.distance + 1));
                    }
                }
            }
            bw.write("#" + tc + " " + time);
            bw.newLine();
        }
        bw.flush();
        bw.close();
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
