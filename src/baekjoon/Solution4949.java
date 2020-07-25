package baekjoon;

import java.io.*;
import java.util.Stack;

//균형잡힌 세상

public class Solution4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            char[] input = br.readLine().toCharArray();

            int length = input.length;

            if(length == 1 && input[0] == '.'){
                bw.flush();
                bw.close();
                return;
            }

            Stack<Character> stack = new Stack<>();
            boolean error = false;
            for (int i = 0; i < length; i++) {
                char now = input[i];

                if(now == '(' || now == '['){
                    stack.push(now);
                }else if(now == ')'){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        error = true;
                        break;
                    }
                }else if(now == ']'){
                    if(!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }else{
                        error = true;
                        break;
                    }
                }
            }

            if(stack.isEmpty() && !error){
                bw.write("yes");
                bw.newLine();
            }else{
                bw.write("no");
                bw.newLine();
            }

        }
    }
}
