package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 단어 뒤집기 2
public class Solution17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().trim().toCharArray();

        boolean tag = false;
        boolean space = false;

        int length = input.length;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char now = input[i];

            if(tag){
                if(now == '>'){
                    tag = false;
                    sb.append('>');
                }else{
                    sb.append(now);
                }
            }else{
                if(now == '<'){
                    while (!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append('<');
                    tag = true;
                }else if(now == ' '){
                    while (!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(" ");
                }else{
                    stack.push(now);
                }
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
