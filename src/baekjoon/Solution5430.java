package baekjoon;

// AC

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Solution5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < testCase; tc++) {
            Deque<String> deque = new LinkedList<>();
            char[] command = br.readLine().trim().toCharArray();

            int size = Integer.parseInt(br.readLine().trim());
            String input = br.readLine();
            int strLen = input.length();


            boolean error = false;
            input = input.substring(1, strLen - 1);
            String[] numStr = input.split(",");

            for (int i = 0; i < size; i++) {
                deque.add(numStr[i]);
            }
            int commandLen = command.length;
            boolean front = true; // true = 앞에서 부터 , false = 뒤에서 부터
            for (int i = 0; i < commandLen; i++) {
                char now = command[i];

                if(now == 'R'){
                    front = !front;
                }else{
                    if(!deque.isEmpty()){
                        if(front){
                            deque.removeFirst();
                        }else{
                            deque.removeLast();
                        }
                    }else{
                        error = true;
                        break;
                    }
                }
            }
            if(error){
                bw.write("error");
            }else{
                sb.setLength(0);
                sb.append("[");

                if(!deque.isEmpty()){
                    if(front){
                        while (deque.size() != 1){
                            sb.append(deque.removeFirst());
                            sb.append(",");
                        }
                    }else{
                        while (deque.size() != 1){
                            sb.append(deque.removeLast());
                            sb.append(",");
                        }
                    }
                    sb.append(deque.remove());
                }

                sb.append("]");
                bw.write(sb.toString());
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
