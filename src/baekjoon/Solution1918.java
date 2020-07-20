package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 후위 표기식

public class Solution1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] input = br.readLine().trim().toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            char now = input[i];
            if(now >= 'A' && now <= 'Z'){
                sb.append(now);
            }else if(now == '('){
                stack.push(now);
            }else if(now == ')'){
                while (true){
                    char op = stack.pop();
                    if(op == '('){
                        break;
                    }
                    sb.append(op);
                }
            }else{
                while (!stack.isEmpty() && priority(now) <= priority(stack.peek())){
                    sb.append(stack.pop());
                }
                stack.push(now);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
    static int priority(char ch) {
        if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '(') {
            return 0;
        } else {
            return -1;
        }
    }

}
