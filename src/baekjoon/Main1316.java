package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int wordNum = Integer.parseInt(br.readLine());
        int count = 0;
        for (int w = 0; w < wordNum; w++) {
            char[] word = br.readLine().toCharArray();
            boolean check = true;

            HashSet<Character> set = new HashSet<>();
            set.add(word[0]);
            for (int i = 1; i < word.length; i++) {
                if(word[i - 1] != word[i]){
                    if(!set.add(word[i])) {
                        check = false;
                        break;
                    }
                }
            }
            if(check)
                count++;
        }
        System.out.println(count);
    }
}
