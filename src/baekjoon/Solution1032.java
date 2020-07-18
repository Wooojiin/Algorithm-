package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//	명령 프롬프트

public class Solution1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine().trim());

        String[] arr = new String[number];

        for (int n = 0; n < number; n++) {
            arr[n] = br.readLine();
        }

        int length = arr[0].length();

        char[] result = arr[0].toCharArray();

        for (int i = 1; i < number; i++) {
            for (int j = 0; j < length; j++) {
                if(result[j] != '?' && result[j] != arr[i].charAt(j)){
                    result[j] = '?';
                }
            }
        }

        System.out.println(new String(result));
    }
}
