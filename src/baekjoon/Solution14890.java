package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 경사로

public class Solution14890 {
    static int size, limitLen, count;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sizeStr = br.readLine().trim().split(" ");

        size = Integer.parseInt(sizeStr[0]);
        limitLen = Integer.parseInt(sizeStr[1]);

        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().trim().split(" ");

            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 가로 탐색
        for (int i = 0; i < size; i++) {
            boolean isOk = true;
            boolean[] used = new boolean[size];

            for (int j = 0; j < size - 1; j++) {
                int now = map[i][j];
                int next = map[i][j + 1];

                int diff = now - next;

                if(Math.abs(diff) > 1){
                    isOk = false;
                    break;
                }else if(diff == -1){
                    int sameLen = 0;
                    for (int k = 0; k < limitLen; k++) {
                        if(j - k >= 0 && now == map[i][j - k] && !used[j - k]){
                            sameLen++;
                        }
                    }
                    if(sameLen == limitLen){
                        for (int k = 0; k < limitLen; k++) {
                            used[j - k] = true;
                        }
                    }else{
                        isOk = false;
                        break;
                    }
                }else if(diff == 1){
                    int sameLen = 0;
                    for (int k = 0; k < limitLen; k++) {
                        if(j + 1 + k < size && next == map[i][j + 1 + k] && !used[j + 1 + k]){
                            sameLen++;
                        }
                    }
                    if(sameLen == limitLen){
                        for (int k = 0; k < limitLen; k++) {
                            used[j + 1 + k] = true;
                        }
                    }else{
                        isOk = false;
                        break;
                    }
                }
            }

            if(isOk){
                count++;
            }
        }

        // 세로 탐색
        for (int j = 0; j < size; j++) {
            boolean isOk = true;
            boolean[] used = new boolean[size];

            for (int i = 0; i < size - 1; i++) {
                int now = map[i][j];
                int next = map[i + 1][j];

                int diff = now - next;

                if(Math.abs(diff) > 1){
                    isOk = false;
                    break;
                }else if(diff == -1){
                    int sameLen = 0;
                    for (int k = 0; k < limitLen; k++) {
                        if(i - k >= 0 && now == map[i - k][j] && !used[i - k]){
                            sameLen++;
                        }
                    }
                    if(sameLen == limitLen){
                        for (int k = 0; k < limitLen; k++) {
                            used[i - k] = true;
                        }
                    }else{
                        isOk = false;
                        break;
                    }
                }else if(diff == 1){
                    int sameLen = 0;
                    for (int k = 0; k < limitLen; k++) {
                        if(i + 1 + k < size && next == map[i + 1 + k][j] && !used[i + 1 + k]){
                            sameLen++;
                        }
                    }
                    if(sameLen == limitLen){
                        for (int k = 0; k < limitLen; k++) {
                            used[i + 1 + k] = true;
                        }
                    }else{
                        isOk = false;
                        break;
                    }
                }
            }
            if(isOk){
                count++;
            }
        }
        System.out.println(count);
    }
}
