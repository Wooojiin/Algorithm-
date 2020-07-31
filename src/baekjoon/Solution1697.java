package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 숨바꼭질

public class Solution1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().trim().split(" ");

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        Queue<Move> queue = new LinkedList<>();

        boolean[] visit = new boolean[100001];

        queue.add(new Move(start, 0));
        int tryNum = 0;

        while(!queue.isEmpty()){
            Move now = queue.poll();
            visit[now.num] = true;

            if(now.num == end){
                tryNum = now.count;
                break;
            }

            if(now.num * 2 <= 100000 && !visit[now.num * 2])
                queue.add(new Move(now.num * 2, now.count + 1));
            if(now.num < 100000 &&!visit[now.num + 1])
                queue.add(new Move(now.num + 1, now.count + 1));
            if(now.num > 0 && !visit[now.num - 1])
                queue.add(new Move(now.num - 1, now.count + 1));
        }

        System.out.println(tryNum);
    }

    static class Move{
        int num, count;

        Move(int num, int count){
            this.num = num;
            this.count = count;
        }
    }
}
