package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// 숫자 카드

public class Solution10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashSet<Integer> set = new HashSet<>();

        int size = Integer.parseInt(br.readLine().trim());
        String[] input = br.readLine().trim().split(" ");

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(input[i]);
            set.add(num);
        }

        size = Integer.parseInt(br.readLine().trim());
        String[] check = br.readLine().trim().split(" ");

        for (int i = 0; i < size; i++) {
            int num = Integer.parseInt(check[i]);

            if(set.add(num)){
                sb.append(0 + " ");
            }else{
                sb.append(1 + " ");
            }
        }

        System.out.println(sb.toString());
    }
}
