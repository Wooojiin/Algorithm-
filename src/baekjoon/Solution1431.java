package baekjoon;

import java.io.*;
import java.util.Arrays;

// 시리얼 번호

public class Solution1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine().trim());
        SerialNum[] arr = new SerialNum[num];

        for (int i = 0; i < num; i++) {
            String input = br.readLine().trim();

            char[] chars = input.toCharArray();
            int sum = 0;

            for (int j = 0; j < chars.length; j++) {
                char now = chars[j];

                if(now >= '0' && now <= '9'){
                    sum += (now - '0');
                }
            }

            arr[i] = new SerialNum(input, sum);
        }

        Arrays.sort(arr);

        for (int i = 0; i < num; i++) {
            bw.write(arr[i].str);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static class SerialNum implements Comparable<SerialNum>{
        String str;
        int num;

        SerialNum(String str, int num){
            this.str = str;
            this.num = num;
        }

        @Override
        public int compareTo(SerialNum o) {
            if(this.str.length() == o.str.length()){
                if(this.num == o.num){
                    return this.str.compareTo(o.str);
                }else
                    return this.num - o.num;
            }else
                return this.str.length() - o.str.length();
        }
    }
}
