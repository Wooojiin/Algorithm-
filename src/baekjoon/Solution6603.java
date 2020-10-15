package baekjoon;

import java.io.*;
import java.util.LinkedList;

// 로또

public class Solution6603 {
    static BufferedWriter bw;
    static StringBuilder sb;
    static LinkedList<Integer> list;
    static boolean[] used;
    static int[] arr;
    static int len;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        while(true){
            String[] inputs = br.readLine().trim().split(" ");

            len = inputs.length - 1;
            if(len == 0 && inputs[0].equals("0")){
                break;
            }
            arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = Integer.parseInt(inputs[i + 1]);
            }

            used = new boolean[len];
            list = new LinkedList<>();

            find(0, 0);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static void find(int count, int now) throws IOException {
        if(count == 6){
            sb.setLength(0);

            for (int i = 0; i < 6; i++) {
                sb.append(list.get(i) + " ");
            }

            bw.write(sb.toString());
            bw.newLine();
            return;
        }

        for (int i = now; i < len; i++) {
            if(!used[i]){
                used[i] = true;
                list.add(arr[i]);
                find(count + 1, i + 1);
                used[i] = false;
                list.removeLast();
            }
        }
    }
}
