package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 빗물

public class Solution14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputSize = br.readLine().trim().split(" ");
        int height = Integer.parseInt(inputSize[0]);
        int width = Integer.parseInt(inputSize[1]);
        String[] input = br.readLine().trim().split(" ");
        int[] blocks = new int[width];

        int sum = 0;

        for (int i = 0; i < width; i++) {
            blocks[i] = Integer.parseInt(input[i]);
        }

        for (int i = 1; i < width - 1; i++) {
            int now = blocks[i];
            int left = 0;
            int right = 0;

            for (int j = i - 1; j >= 0; j--) {  // left
                if(left <= blocks[j]){
                    left = blocks[j];
                }
            }

            for (int j = i + 1; j <  width; j++) {  // right
                if(right <= blocks[j]){
                    right = blocks[j];
                }
            }

            int water = Math.min(left, right) - now;

            if(water > 0){
                sum += water;
            }
        }
        System.out.println(sum);
    }
}
