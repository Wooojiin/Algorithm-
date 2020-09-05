package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

// 카드 2

public class Solution2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine().trim());

        LinkedList<Integer> card = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            card.add(i+1);
        }

        while(card.size()!=1) {
            card.pop();

            int tmp = card.pop();
            card.addLast(tmp);
        }
        System.out.println(card.pop());
    }
}
