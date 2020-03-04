package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cmdNumber = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        int backNum = 0;
        for (int i = 0; i < cmdNumber; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]){
                case "push":
                    backNum = Integer.parseInt(input[1]);
                    queue.add(backNum);
                    break;
                case "pop":
                    bw.append((queue.isEmpty() ? -1 : queue.poll()) + "\n");
                    break;
                case "size":
                    bw.append(queue.size() + "\n");
                    break;
                case "empty":
                    bw.append((queue.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write((queue.isEmpty() ? -1 : queue.peek()) + "\n");
                    break;
                case "back":
                    bw.write((queue.isEmpty() ? -1 : backNum) + "\n");
                    break;
            }
        }
        bw.flush();
    }

}
