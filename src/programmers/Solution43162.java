package programmers;

// 네트워크

public class Solution43162 {
    public static void main(String[] args) {
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(solution(3, computers));
    }

    static boolean[] visit;
    public static int solution(int n, int[][] computers) {
        int answer = 0;

        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visit[i]){
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }

    static void dfs(int now, int n, int[][] computers){
        visit[now] = true;

        for (int i = 0; i < n; i++) {
            if(computers[now][i] == 1 && !visit[i]){
                visit[i] = true;
                dfs(i,n, computers);
            }
        }
    }
}
