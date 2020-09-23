package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 가장 긴 증가하는 부분 수열

public class Solution11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int[] arr = new int[size + 1];

        String[] input = br.readLine().trim().split(" ");
        for (int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(input[i - 1]);
        }

        int[] res = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            res[i] = 1;
            for (int j = 1; j <= i - 1; j++) {
                if(arr[i] > arr[j] && res[i] < res[j] + 1){
                    res[i] = res[j] + 1;
                }
            }
        }
        Arrays.sort(res);
        System.out.println(res[size]);
    }
}
