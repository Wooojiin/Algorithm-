package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

// 덱

public class Solution10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine().trim());
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < num; i++) {
            String[] command = br.readLine().trim().split(" ");

            if(command[0].equals("size")){
                bw.write(deque.size() + "");
                bw.newLine();
            }else if(command[0].equals("empty")){
                if(deque.isEmpty()){
                    bw.write(1 + "");
                }else{
                    bw.write(0 + "");
                }
                bw.newLine();
            }else if(command[0].equals("front")){
                if(deque.isEmpty()){
                    bw.write(-1 + "");
                }else{
                    bw.write(deque.peekFirst() + "");
                }
                bw.newLine();
            }else if(command[0].equals("back")){
                if(deque.isEmpty()){
                    bw.write(-1 + "");
                }else{
                    bw.write(deque.peekLast() + "");
                }
                bw.newLine();
            }else if(command[0].equals("push_front")){
                int number = Integer.parseInt(command[1]);

                deque.addFirst(number);
            }else if(command[0].equals("push_back")){
                int number = Integer.parseInt(command[1]);

                deque.addLast(number);
            }else if(command[0].equals("pop_front")){
                if(deque.isEmpty()){
                    bw.write(-1 + "");
                }else{
                    bw.write(deque.pollFirst() + "");
                }
                bw.newLine();
            }else{
                if(deque.isEmpty()){
                    bw.write(-1 + "");
                }else{
                    bw.write(deque.pollLast() + "");
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
