package baekjoon;

import java.io.*;

// 팰린드롬수

public class Solution1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String number = br.readLine().trim();

        while(!number.equals("0")){
            boolean check = true;
            int length = number.length();
            int checkLength = length / 2;
            for (int i = 0; i < checkLength; i++) {
                if(number.charAt(i) != number.charAt(length - 1 - i)){
                    check = false;
                    break;
                }
            }

            if(check)
                bw.write("yes\n");
            else
                bw.write("no\n");

            number = br.readLine().trim();
        }
        bw.flush();
        bw.close();
    }
}
