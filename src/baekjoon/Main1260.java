package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1260 {
    static int V, E, start;
    static boolean[] visit;
    static boolean[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        start = Integer.parseInt(input[2]);

        visit = new boolean[V + 1];
        arr = new boolean[V + 1][V + 1];

        for (int i = 1; i <= E; i++) {
            String[] edge = br.readLine().split(" ");
            int v1 = Integer.parseInt(edge[0]);
            int v2 = Integer.parseInt(edge[1]);

            arr[v1][v2] = true;
            arr[v2][v1] = true;
        }

        dfs(start);
        System.out.println();

        visit = new boolean[V + 1];

        bfs(start);
    }

    static void dfs(int now){
        System.out.print(now + " ");
        visit[now] = true;

        for (int i = 1; i <= V; i++) {
            if(arr[now][i] && !visit[i]){
                visit[i] = true;
                dfs(i);
                ;            }
        }
    }

    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();

        que.add(start);

        while (!que.isEmpty()){
            int now = que.poll();
            System.out.print(now + " ");

            visit[now] = true;

            for (int i = 1; i <= V ; i++) {
                if(arr[now][i] && !visit[i]){
                    visit[i] = true;
                    que.add(i);
                }
            }
        }
    }
}
