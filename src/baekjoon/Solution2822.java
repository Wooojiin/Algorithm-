package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 점수 계산

public class Solution2822 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Problem[] arr = new Problem[8];
        for (int i = 1; i <= 8; i++) {
            int score = Integer.parseInt(br.readLine().trim());

            arr[i - 1] = new Problem(i, score);
        }

        Arrays.sort(arr);

        int[] nums = new int[5];
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += arr[7 - i].score;
            nums[i] = arr[7 - i].num;
        }
        System.out.println(sum);
        Arrays.sort(nums);

        for (int i = 0; i < 5; i++) {
            sb.append(nums[i] + " ");
        }
        System.out.println(sb.toString());
    }

    static class Problem implements Comparable<Problem>{
        int num, score;

        Problem(int num, int score){
            this.num = num;
            this.score = score;
        }

        @Override
        public int compareTo(Problem o) {
            return this.score - o.score;
        }
    }
}
