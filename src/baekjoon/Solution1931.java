package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 회의실 배정

public class Solution1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine().trim());

        ArrayList<Meet> total = new ArrayList<>();
        ArrayList<Meet> confirm = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            String[] input = br.readLine().trim().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            total.add(new Meet(start, end));
        }

        Collections.sort(total);

        confirm.add(total.get(0));

        int index = 0;
        for (int i = 1; i < length; i++) {
            Meet unconfirmed = total.get(i);

            if(unconfirmed.start >= confirm.get(index).end){
                confirm.add(unconfirmed);
                index++;
            }
        }

        System.out.println(confirm.size());
    }
    static class Meet implements Comparable<Meet>{
        int start, end;

        Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet o) {
            if(this.end == o.end)
                return this.start - o.start;
            return this.end - o.end;
        }
    }
}
