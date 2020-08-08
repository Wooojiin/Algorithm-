package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// ABC

public class Solution3047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().trim().split(" ");
        char[] alpha = br.readLine().trim().toCharArray();

        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(numbers);

        for (int i = 0; i < 3; i++) {
            int now = alpha[i] - 'A';
            sb.append(numbers[now] + " ");
        }

        System.out.println(sb.toString());
    }
}
