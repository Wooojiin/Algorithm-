package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// 게리맨더링

public class Solution17471 {
    static int peopleNum;
    static int[] people;
    static boolean[] check;

    static boolean[][] map;
    static int min;

    static Set<String> set;
    static StringBuilder sb;
    static LinkedList<Integer> group1, group2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        peopleNum = Integer.parseInt(br.readLine().trim());
        people = new int[peopleNum];
        check = new boolean[peopleNum];

        String[] peoples = br.readLine().trim().split(" ");

        for (int i = 0; i < peopleNum; i++) {
            people[i] = Integer.parseInt(peoples[i]);
        }

        map = new boolean[peopleNum][peopleNum];
        for (int i = 0; i < peopleNum; i++) {
            String[] connect = br.readLine().trim().split(" ");
            int connectNum = Integer.parseInt(connect[0]);
            for (int j = 1; j <= connectNum; j++) {
                int connected = Integer.parseInt(connect[j]) - 1;

                map[i][connected] = true;
            }
        }

        min = Integer.MAX_VALUE;
        group1 = new LinkedList<>();
        group2 = new LinkedList<>();

        set = new HashSet<>();
        sb = new StringBuilder();

        grouping(0, 0);


        if(min == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }

    static void grouping(int count, int start){
        if(count > 0 && count < peopleNum ){
            group2.clear();
            sb.setLength(0);

            for (int i = 0; i < peopleNum; i++) {
                if(!check[i]){
                    group2.add(i);
                    sb.append(i);
                }
            }

            if(!set.add(sb.toString())){
                return;
            }

            if(valid(group1) && valid(group2)){
                int group1Num = countPeople(group1);
                int group2Num = countPeople(group2);


                min = Integer.min(min, Math.abs(group1Num - group2Num));
            }
        }

        if(count == peopleNum - 1)
            return;

        for (int i = start; i < peopleNum; i++) {
            if(!check[i]){
                check[i] = true;
                group1.add(i);
                grouping(count + 1, start + 1);
                check[i] = false;
                group1.removeLast();
            }
        }
    }

    static boolean valid(LinkedList<Integer> list){
        int start = list.getFirst();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[peopleNum];
        queue.add(start);
        int size = 0;

        while(!queue.isEmpty()){
            int now = queue.poll();
            size++;
            visit[now] = true;

            for (int i = 0; i < peopleNum; i++) {
                if(map[now][i] && !visit[i] && list.contains(i)){
                    visit[i] = true;
                    queue.add(i);
                }
            }
        }

        return size == list.size();
    }

    static int countPeople(LinkedList<Integer> list){
        int sum = 0;

        for (int now : list) {
            sum += people[now];
        }
        return sum;
    }
}