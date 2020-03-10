package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < testCase; tc++) {
            String[] info = br.readLine().split(" ");

            int city = Integer.parseInt(info[0]);
            int plane = Integer.parseInt(info[1]);

            for (int i = 0; i < plane; i++) {
                br.readLine();
            }

            System.out.println(city - 1);
        }
    }
}
