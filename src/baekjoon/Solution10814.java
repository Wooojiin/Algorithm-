package baekjoon;

import java.io.*;
import java.util.PriorityQueue;

// 나이순 정렬

public class Solution10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int peopleNum = Integer.parseInt(br.readLine().trim());

        PriorityQueue<People> pq = new PriorityQueue<>();
        for (int i = 0; i < peopleNum; i++) {
            String[] input = br.readLine().trim().split(" ");
            int age = Integer.parseInt(input[0]);

            pq.add(new People(age, input[1], i));
        }

        for (int i = 0; i < peopleNum; i++) {
            People now = pq.poll();
            bw.write(now.age + " " + now.name);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class People implements Comparable<People>{
        int age;
        int num;
        String name;

        People(int age, String name, int num){
            this.age = age;
            this.name = name;
            this.num = num;
        }

        @Override
        public int compareTo(People o) {
            if(this.age == o.age)
                return this.num - o.num;
            return this.age - o.age;
        }
    }
}
