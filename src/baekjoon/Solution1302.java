package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 베스트셀러

public class Solution1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();
        int num = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < num; i++) {
            String name = br.readLine();

            if(map.containsKey(name)){
                int count = map.get(name);

                map.replace(name, count + 1);
            }else{
                map.put(name, 1);
            }
        }
        LinkedList<String> keyList = new LinkedList<>(map.keySet());

        int max = 0;
        int size = keyList.size();
        for (int i = 0; i < size; i++) {
            max = Integer.max(max, map.get(keyList.get(i)));
        }

        Collections.sort(keyList);
        String best = "";
        for (int i = 0; i < size; i++) {
            String now = keyList.get(i);
            if(max == map.get(now)){
                best = now;
                break;
            }
        }
        System.out.println(best);
    }
}
