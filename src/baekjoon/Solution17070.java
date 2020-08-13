package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 파이프 옮기기 1

public class Solution17070 {
    static int size;
    static int[][] map;
    static Pipe[][] status;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine().trim());
        map = new int[size][size];
        status = new Pipe[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().trim().split(" ");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                status[i][j] = new Pipe();
            }
        }

        status[0][1].dir[0] = true;
        status[0][1].count[0] = 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(map[i][j] == 0){ // 벽이 아니면

                    Pipe now = status[i][j];

                    // 가로
                    if(now.dir[0]){ // 가로로 끝난 경우
                        // 다음 가로
                        if(j + 1 < size && map[i][j + 1] == 0 && !status[i][j + 1].dir[0]){
                            status[i][j + 1].dir[0] = true;
                            status[i][j + 1].count[0] = now.count[0] + now.count[1];  // 가로랑 대각선만 가능
                        }
                        // 다음 대각선
                        if(i + 1 < size && j + 1 < size && map[i + 1][j] == 0 && map[i][j + 1] == 0 && map[i + 1][j + 1] == 0
                        && !status[i + 1][j + 1].dir[1]){
                            status[i + 1][j + 1].dir[1] = true;
                            status[i + 1][j + 1].count[1] = now.count[0] + now.count[1] + now.count[2];  // 가로, 대각선, 세로 모두 가능
                        }
                    }

                    // 대각선
                    if(now.dir[1]){
                        // 다음 가로
                        if(j + 1 < size && map[i][j + 1] == 0 && !status[i][j + 1].dir[0]){
                            status[i][j + 1].dir[0] = true;
                            status[i][j + 1].count[0] = now.count[0] + now.count[1];  // 가로랑 대각선만 가능
                        }
                        // 다음 대각선
                        if(i + 1 < size && j + 1 < size && map[i + 1][j] == 0 && map[i][j + 1] == 0 && map[i + 1][j + 1] == 0
                                && !status[i + 1][j + 1].dir[1]){
                            status[i + 1][j + 1].dir[1] = true;
                            status[i + 1][j + 1].count[1] = now.count[0] + now.count[1] + now.count[2];  // 가로, 대각선, 세로 모두 가능
                        }
                        // 다음 세로
                        if(i + 1 < size && map[i + 1][j] == 0 && !status[i + 1][j].dir[2]){
                            status[i + 1][j].dir[2] = true;
                            status[i + 1][j].count[2] = now.count[1] + now.count[2];// 대각선, 세로만 가능
                        }
                    }

                    //세로
                    if(now.dir[2]){
                        // 다음 대각선
                        if(i + 1 < size && j + 1 < size && map[i + 1][j] == 0 && map[i][j + 1] == 0 && map[i + 1][j + 1] == 0
                                && !status[i + 1][j + 1].dir[1]){
                            status[i + 1][j + 1].dir[1] = true;
                            status[i + 1][j + 1].count[1] = now.count[0] + now.count[1] + now.count[2];  // 가로, 대각선, 세로 모두 가능
                        }
                        // 다음 세로
                        if(i + 1 < size && map[i + 1][j] == 0 && !status[i + 1][j].dir[2]){
                            status[i + 1][j].dir[2] = true;
                            status[i + 1][j].count[2] = now.count[1] + now.count[2];// 대각선, 세로만 가능
                        }
                    }
                }
            }
        }

        int result = status[size - 1][size - 1].count[0] + status[size - 1][size - 1].count[1] + status[size - 1][size - 1].count[2];

        System.out.println(result);
    }

    static class Pipe{
        boolean[] dir;
        int[] count;

        Pipe(){
            this.dir = new boolean[3];
            this.count = new int[3];
        }
    }
}
