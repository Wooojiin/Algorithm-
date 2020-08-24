package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 바이러스

public class Solution2606 {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine().trim());
        arr = new int[size + 1];

        int tc = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= size; i++) {
            arr[i] = i;
        }
        for (int t = 0; t < tc; t++) {
            String[] input = br.readLine().trim().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);

            union(n1, n2);
        }

        for (int i = 1; i <= size; i++) {
            find(i);
        }
        int cnt = 0;
        for (int i = 2; i <= size; i++) {
            if(arr[i] == arr[1])
                cnt++;
        }
        System.out.println(cnt);

    }

    static int find(int n) {
        if(n == arr[n])
            return n;
        else {
            int p = find(arr[n]);
            arr[n] = p;
            return p;
        }
    }

    static void union(int n1, int n2) {
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 != p2) {
            arr[p1] = p2;
        }
    }
}

