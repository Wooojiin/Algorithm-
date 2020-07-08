package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 쇠막대기

public class Solution10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine().trim();
        int length = input.length();

        int count = 0;
        boolean laser = false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            char now = input.charAt(i);

            if(now == '('){
                stack.push('(');
                laser = true;
            }else if(now == ')' && laser){ // 레이저인 경우
                stack.pop();
                count += stack.size();
                laser = false;
            }else if(now == ')' && !laser){ // 막대 끝인 경우
                stack.pop();
                count++;
            }
        }
        System.out.println(count);
    }
}
