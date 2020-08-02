package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main10026 {
    static int size;
    static char[][] map;
    static boolean[][] visitNormal;
    static boolean[][] visitRG;
    static int countNormal, countRG;

    static int[] di = {0,0,-1,1};
    static int[] dj = {-1,1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        map = new char[size][size];
        visitNormal = new boolean[size][size];
        visitRG = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            map[i] = br.readLine().toCharArray();
        }
        countNormal = countRG = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(!visitNormal[i][j]){
                    countNormal++;
                    findNormal(i, j);
                }
                if(!visitRG[i][j]){
                    countRG++;
                    findRG(i, j);
                }
            }
        }

        System.out.println(countNormal + " " + countRG);
    }

    public static void findNormal(int i, int j){
        visitNormal[i][j] = true;
        char color = map[i][j];

        for (int d = 0; d < 4; d++) {
            int nexti = i + di[d];
            int nextj = j + dj[d];

            if(nexti >= 0 && nexti < size && nextj >= 0 && nextj < size && !visitNormal[nexti][nextj] && map[nexti][nextj] == color){
                findNormal(nexti, nextj);
            }
        }
    }

    public static void findRG(int i, int j){
        visitRG[i][j] = true;
        char color = map[i][j];

        for (int d = 0; d < 4; d++) {
            int nexti = i + di[d];
            int nextj = j + dj[d];

            if(nexti >= 0 && nexti < size && nextj >= 0 && nextj < size && !visitRG[nexti][nextj]){
                if(color == 'R' || color == 'G'){
                    if(map[nexti][nextj] == 'R' || map[nexti][nextj] == 'G')
                        findRG(nexti, nextj);
                }else {
                    if(map[nexti][nextj] == color)
                        findRG(nexti, nextj);
                }
            }
        }

    }
}
