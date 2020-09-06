package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 원판 돌리기

public class Solution17822 {
    static int N, M, T;
    static int[][] map;
    static int[][] turn;

    static int[] di = { -1, 1, 0, 0 };
    static int[] dj = { 0, 0, -1, 1 };

    static boolean chk;
    static double avg;
    static int div;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().trim().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        T = Integer.parseInt(line[2]);

        map = new int[N + 1][M];
        turn = new int[T][3];

        for (int i = 1; i <= N; i++) {
            String[] in = br.readLine().trim().split(" "); // M개 숫자
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(in[j]);
            }
        }

        for (int i = 0; i < T; i++) {
            String[] in = br.readLine().trim().split(" ");
            for (int j = 0; j < 3; j++) {
                turn[i][j] = Integer.parseInt(in[j]);
            }
        }

        rotation();
        System.out.println(sum());
    }

    static void rotation() {

        for (int t = 0; t < T; t++) { // 회전 횟수
            int num = turn[t][0];
            int dir = turn[t][1];
            int cnt = turn[t][2];

            for (int i = 1; i <= N; i++) {
                if (i % num == 0) { // x의 배수인 원판만 회전
                    int[] tmp = new int[M];
                    System.arraycopy(map[i], 0, tmp, 0, M);

                    if (dir == 0) { // 시계 방향
                        for (int j = 0; j < M; j++) {
                            map[i][(j + cnt) % M] = tmp[j];
                        }
                    } else { // 반시계 방향
                        for (int j = 0; j < M; j++) {
                            map[i][(M + (j - cnt)) % M] = tmp[j];
                        }
                    }
                }
            } // 1번 회전 완료
            chk = false;

            for (int i = 1; i <= N; i++) { // 인접 & 같은 숫자 찾아서 제거
                for (int j = 0; j < M; j++) {
                    if(map[i][j] != 0) {
                        erase(i, j, map[i][j]);
                    }
                }
            }
            if(!chk) { // 인접 & 같은 숫자 없는 경우
                avg = (double)sum() / div;
                addsub();
            }
        }
    }

    static void erase(int ni, int nj, int val) {  // 같은 숫자 찾아서 지움

        for (int d = 0; d < 4; d++) {
            int nexti = ni + di[d];
            int nextj = nj + dj[d];

            if(nexti > 0 && nexti <= N) {
                if (nextj < 0) { // j가 0또는
                    nextj = M - 1;
                } else if (nextj >= M) { // 마지막 인덱스인 경우
                    nextj = 0;
                }

                if (val == map[nexti][nextj]) {
                    map[ni][nj] = map[nexti][nextj] = 0;
                    chk = true;
                    erase(nexti, nextj, val);
                }
            }
        }
    }

    static void addsub() { // 평균과 비교하여 빼거나 더함
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0) {
                    if(map[i][j] > avg)
                        map[i][j]--;
                    else if(map[i][j] < avg)
                        map[i][j]++;
                }
            }
        }
    }

    static int sum() {
        int res = 0;
        div = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0) {
                    div++;
                    res += map[i][j];
                }
            }
        }
        return res;
    }
}
