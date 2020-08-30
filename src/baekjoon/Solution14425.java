package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// 문자열 집합

public class Solution14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().trim().split(" ");

        int setSize = Integer.parseInt(size[0]);
        int checkSize = Integer.parseInt(size[1]);

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < setSize; i++) {
            set.add(br.readLine().trim());
        }

        int count = 0;
        for (int i = 0; i < checkSize; i++) {
            if(set.contains(br.readLine().trim())){
                count++;
            }
        }

        System.out.println(count);
    }
}
