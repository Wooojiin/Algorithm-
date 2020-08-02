package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;

public class Main5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {

            char[] logger = br.readLine().toCharArray();
            sb.setLength(0);
            LinkedList<Character> list = new LinkedList<>();

            int move = 0;

            for (int i = 0; i < logger.length; i++) {
                switch (logger[i]){
                    case '<':
                        move--;
                        break;
                    case '>':
                        move++;
                        break;
                    case '-':
                        if(move < 0){
                            if(Math.abs(move) < list.size()){
                                list.remove(list.size() + move);
                                move = list.size() + move;
                            }
                        }else {
                            list.removeLast();
                            move = list.size() - 1;
                        }
//                        move = 0;
                        break;
                    default:
                        if(move < 0){
                            if(Math.abs(move) >= list.size()){
                                list.add(0, logger[i]);
                            }else{
                                list.add(list.size() + move, logger[i]);
                            }
                        }else{
                            list.add(logger[i]);
                        }
                        move = 0;
                }
            }

            for (char pwd : list) {
                sb.append(pwd);
            }
            System.out.println(sb.toString());
        }
    }
}
