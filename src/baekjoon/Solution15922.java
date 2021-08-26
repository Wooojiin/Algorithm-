package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//아우으 우아으이야!!

public class Solution15922 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int sum = 0;

        LinkedList<Line> list = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            String[] input = br.readLine().trim().split(" ");

            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);

            int size = list.size();

            if(size > 0){
                Line pre = list.get(size - 1);
                if(left <= pre.right){  // 겹치면
                    if(right > pre.right){  // 더 길어지는 경우
                        pre.right = right;
                        list.removeLast();
                        list.add(pre);
                    }
                }else{
                    list.add(new Line(left, right));
                }
            }else{
                list.add(new Line(left, right));
            }
        }
        for (Line line : list) {
            sum += (line.right - line.left);
        }
        System.out.println(sum);
    }

    static class Line{
        int left, right;

        Line(int left, int right){
            this.left = left;
            this.right = right;
        }
    }
}
