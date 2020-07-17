package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 촌수계산

public class Solution2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int peopleNum = Integer.parseInt(br.readLine().trim());

        String[] people = br.readLine().trim().split(" ");

        int people1 = Integer.parseInt(people[0]);
        int people2 = Integer.parseInt(people[1]);

        int connectionNum = Integer.parseInt(br.readLine());

        boolean[][] map = new boolean[peopleNum + 1][peopleNum + 1];
        boolean[] visit = new boolean[peopleNum + 1];

        for (int i = 0; i < connectionNum; i++) {
            String[] input = br.readLine().trim().split(" ");

            int first = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[1]);

            map[first][second] = true;
            map[second][first] = true;
        }

        Queue<People> queue = new LinkedList<>();
        queue.add(new People(people1, 0));
        visit[people1] = true;

        boolean connect = false;
        int distance = 0;

        while(!queue.isEmpty()){
            People now = queue.poll();

            if(now.num == people2){
                connect = true;
                distance = now.distance;
                break;
            }

            for (int i = 1; i <= peopleNum; i++) {
                if(map[now.num][i] && !visit[i]){    // 연결되어있고 아직 안간곳이면
                    queue.add(new People(i, now.distance + 1));
                    visit[i] = true;
                }
            }
        }

        if(!connect)
            System.out.println(-1);
        else
            System.out.println(distance);

    }
    static class People{
        int num, distance;

        People(int num, int distance){
            this.num = num;
            this.distance = distance;
        }
    }
}
