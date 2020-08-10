package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

// 나이트의 이동

public class Solution7562 {
    static int size, result;
    static Position start, end;
    static boolean[][] check;

    static int[] di = {-1, -2, -2, -1, 1, 2,  2,  1};
    static int[] dj = {-2, -1,  1,  2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase= Integer.parseInt(br.readLine().trim());

        for (int t = 0; t < testCase; t++) {
            size = Integer.parseInt(br.readLine());

            check = new boolean[size][size];

            String[] inputStart = br.readLine().trim().split(" ");
            String[] inputEnd = br.readLine().trim().split(" ");


            start = new Position(Integer.parseInt(inputStart[0]), Integer.parseInt(inputStart[1]), 0);
            end = new Position(Integer.parseInt(inputEnd[0]), Integer.parseInt(inputEnd[1]), 0);

            result = 0;
            search();

            bw.write(result + "");
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static void search(){
        Queue<Position> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            Position now = queue.poll();

            check[now.i][now.j] = true;

            if(now.i == end.i && now.j == end.j){
                result = now.move;
                return;
            }

            for (int d = 0; d < 8; d++) {
                int nexti = now.i + di[d];
                int nextj = now.j + dj[d];

                if(nexti >= 0 && nexti < size && nextj >= 0 && nextj < size && !check[nexti][nextj]){
                    if(nexti == end.i && nextj == end.j){
                        result = now.move + 1;
                        return;
                    }
                    check[nexti][nextj] = true;
                    queue.add(new Position(nexti, nextj, now.move + 1));
                }
            }
        }

    }

    static class Position{
        int i, j, move;

        Position(int i, int j, int move){
            this.i = i;
            this.j = j;
            this.move = move;
        }
    }
}
