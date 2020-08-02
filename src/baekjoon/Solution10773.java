package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 제로

public class Solution10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine().trim());

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(br.readLine().trim());

            if(num == 0){
                if(!stack.isEmpty())
                    stack.pop();
            }else{
                stack.push(num);
            }
        }

        int size= stack.size();
        int sum = 0;

        for (int i = 0; i < size; i++) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}
