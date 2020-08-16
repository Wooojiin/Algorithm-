package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

// 암호 만들기

public class Solution1759 {
    static int limit, total;
    static char[] arr;
    static boolean[] chk;
    static LinkedList<Character> list;

    static char[] aeiou = { 'a', 'e', 'i', 'o', 'u' };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().trim().split(" ");

        limit = Integer.parseInt(line[0]);
        total = Integer.parseInt(line[1]);

        arr = new char[total];
        chk = new boolean[total];

        String[] in = br.readLine().trim().split(" ");
        for (int i = 0; i < total; i++) {
            arr[i] = in[i].charAt(0);
        }
        Arrays.sort(arr);

        list = new LinkedList<>();

        find(0, 0);
    }

    static void find(int cnt, int now) {
        if (cnt == limit) {
            int n = check();
            if(n >= 1 && n < limit - 1) {
                for (char c : list) {
                    System.out.print(c);
                }
                System.out.println();
            }
            return;
        }

        for (int i = now; i < total; i++) {
            if (!chk[i]) {
                chk[i] = true;
                list.add(arr[i]);
                find(cnt + 1, i + 1);
                chk[i] = false;
                list.removeLast();
            }
        }
    }

    static int check() {
        int cnt = 0;
        for (char ch : list) {
            for (int i = 0; i < 5; i++) {
                if (ch == aeiou[i]) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}
