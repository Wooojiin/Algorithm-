package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main14889 {
    static int size, limit, min;
    static int[][] map;
    static boolean[] chk;

    static int ability1, ability2;
    static LinkedList<Integer> team1, team2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        map = new int[size][size];
        chk = new boolean[size];

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().trim().split(" ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        limit = size / 2;

        team1 = new LinkedList<>();
        team2 = new LinkedList<>();

        min = Integer.MAX_VALUE;
        make(0, 0);

        System.out.println(min);
    }

    static void make(int cnt, int start){
        if(cnt == limit){
            team2.clear();
            ability1 = ability2 = 0;

            for (int i = 0; i < size; i++) {
                if(!chk[i]){
                    team2.add(i);
                }
            }

            ability1 = sumAbility(team1);
            ability2 = sumAbility(team2);

            min = Math.min(min, Math.abs(ability1 - ability2));

            return;
        }

        for (int i = start; i < size; i++) {
            if(!chk[i]){
                chk[i] = true;
                team1.add(i);
                make(cnt + 1, i + 1);
                chk[i] = false;
                team1.removeLast();
            }
        }
    }

    static int sumAbility(LinkedList<Integer> list){
        int sum = 0;

        for (int i = 0; i < limit - 1; i++) {
            int p1 = list.get(i);
            for (int j = i + 1; j < limit; j++) {
                int p2 = list.get(j);
                sum += getAbility(p1, p2);
            }
        }
        return sum;
    }

    static int getAbility(int i, int j){
        return map[i][j] + map[j][i];
    }
}
