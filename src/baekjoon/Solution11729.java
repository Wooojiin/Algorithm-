package baekjoon;

import java.io.*;

// 하노이 탑 이동 순서

public class Solution11729 {
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = Integer.parseInt(br.readLine().trim());

        bw.write(((int)Math.pow(2.0, number) - 1)  + ""); // 이동 횟수 2 ^ n - 1
        bw.newLine();
        hanoi(number, 1, 2, 3);

        bw.flush();
        bw.close();
    }

    static void move(int start, int end) throws IOException {
        bw.write(start + " " + end );
    }

    static void hanoi(int n, int start, int mid, int end) throws IOException {
        if(n == 1)
            move(start, end);
        else{
            hanoi(n - 1, start, end, mid); // n-1개 시작봉에서 마지막봉 거쳐서 중간봉으로
            bw.newLine();
            move(start, end);   // 1개 시작봉에서 마지막 봉으로
            bw.newLine();
            hanoi(n - 1, mid, start, end); // n-1개 중간봉에서 시작봉 거쳐서 마지막봉으로
        }
    }
}
