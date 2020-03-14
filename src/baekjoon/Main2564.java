package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2564 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().trim().split(" ");

        int isize = Integer.parseInt(size[1]);
        int jsize = Integer.parseInt(size[0]);

        int[] d = { 0, 2 * isize + 2 * jsize, isize, 0, 2 * isize + jsize };

        int num = Integer.parseInt(br.readLine().trim());

        int[] distance = new int[num + 1];

        for (int i = 0; i <= num; i++) {
            String[] in = br.readLine().trim().split(" ");

            int dir = Integer.parseInt(in[0]);
            int dist = Integer.parseInt(in[1]);

            if (dir == 4 || dir == 1) {
                dist = d[dir] - dist;
            } else {
                dist = d[dir] + dist;
            }
            distance[i] = dist;
        }

        int res = 0;
        int dong = distance[num];
        for (int i = 0; i < num; i++) {
            int now = Math.abs(dong - distance[i]);
            if (now > isize + jsize) {
                res += (((isize + jsize) * 2) - now);
            } else {
                res += now;
            }
        }
        System.out.println(res);
    }
}