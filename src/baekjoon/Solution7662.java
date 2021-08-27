package baekjoon;

import java.io.*;
import java.util.TreeMap;

// 이중 우선순위 큐

public class Solution7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < testCase; tc++) {
            int cmdNum = Integer.parseInt(br.readLine().trim());

            TreeMap<Long, Integer> map = new TreeMap<>();

            for (int i = 0; i < cmdNum; i++) {
                String[] input = br.readLine().trim().split(" ");

                if(input[0].equals("I")){
                    long number = Long.parseLong(input[1]);
                    if(map.containsKey(number)){
                        map.put(number, map.get(number) + 1);
                    }else{
                        map.put(number, 1);
                    }
                }else{
                    if(!map.isEmpty()){
                        long removeNum = 0;
                        if(input[1].equals("1")){
                            removeNum = map.lastKey();
                        }else{
                            removeNum = map.firstKey();
                        }
                        int val = map.get(removeNum);
                        if(val == 1){
                            map.remove(removeNum);
                        }else{
                            map.put(removeNum, map.get(removeNum) - 1);
                        }
                    }
                }
            }
            if(map.isEmpty()){
                bw.write("EMPTY");
            }else if(map.size() == 1){
                long result = map.firstKey();
                bw.write(result + " " + result);
            }else{
                bw.write(map.lastKey() + " " + map.firstKey());
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
