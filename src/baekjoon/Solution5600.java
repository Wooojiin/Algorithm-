package baekjoon;

import java.io.*;

// 품질검사

public class Solution5600 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numbers = br.readLine().trim().split(" ");
        int a_num = Integer.parseInt(numbers[0]);
        int b_num = Integer.parseInt(numbers[1]);
        int c_num = Integer.parseInt(numbers[2]);

        int TC = Integer.parseInt(br.readLine().trim());

        int[][] array = new int[TC][4];

        int[] res = new int[a_num + b_num + c_num];

        for (int i = 0; i < TC; i++) {
            String[] input = br.readLine().trim().split(" ");
            for (int j = 0; j < 4; j++) {
                array[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < TC; i++) {
            if (array[i][3] == 1) {
                for (int j = 0; j < 3; j++) {
                    res[array[i][j] - 1] = 2;
                }
            }
        }

        for (int i = 0; i < TC; i++) {
            if (array[i][3] == 0) {
                if (res[array[i][0] - 1] == 2 && res[array[i][1] - 1] == 2) {
                    res[array[i][2] - 1] = 1;
                } else if (res[array[i][0] - 1] == 2 && res[array[i][2] - 1] == 2) {
                    res[array[i][1] - 1] = 1;
                } else if (res[array[i][1] - 1] == 2 && res[array[i][2] - 1] == 2) {
                    res[array[i][0] - 1] = 1;
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] == 2) {
                bw.write("1");
            }
            else if(res[i] == 1) {
                bw.write("0");
            }
            else {
                bw.write("2");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
