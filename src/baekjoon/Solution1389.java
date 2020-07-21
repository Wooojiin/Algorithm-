package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 케빈 베이컨의 6단계 법칙

public class Solution1389 {
    static int V, E;
    static boolean[][] map;
    static boolean[] visit;
    static int minPeople, minValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().trim().split(" ");

        V = Integer.parseInt(size[0]);
        E = Integer.parseInt(size[1]);

        map = new boolean[V + 1][V + 1];

        for (int i = 0; i < E; i++) {
            String[] input = br.readLine().trim().split(" ");

            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);

            map[first][second] = true;
            map[second][first] = true;
        }

        minValue = Integer.MAX_VALUE;
        minPeople = 0;

        for (int i = V; i >= 1; i--) {
            Queue<People> queue = new LinkedList<>();
            visit = new boolean[V + 1];

            queue.add(new People(i, 0));
            visit[i] = true;

            int total = 0;

            while(!queue.isEmpty()){
                People now = queue.poll();
                int nowDistance = now.distance;
                total += nowDistance;

                for (int j = 1; j <=  V; j++) {
                    if(map[now.num][j] && !visit[j]){
                        queue.add(new People(j, nowDistance + 1));
                        visit[j] = true;
                    }
                }
            }

            if(total <= minValue){
                minValue = total;
                minPeople = i;
            }
        }

        System.out.println(minPeople);
    }

    static class People{
        int num, distance;

        People(int num, int distance){
            this.num = num;
            this.distance = distance;
        }
    }
}
