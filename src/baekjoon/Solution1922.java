package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

// 네트워크 연결

public class Solution1922 {
    static int V, E;
    static ArrayList<Edge> mst;
    static PriorityQueue<Edge> pq;
    static int[] arr;
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        V = Integer.parseInt(br.readLine().trim());
        E = Integer.parseInt(br.readLine().trim());

        arr = new int[V + 1];
        mst = new ArrayList<>();
        pq = new PriorityQueue<>();

        for (int i = 1; i <= V; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < E; i++) {
            String[] input = br.readLine().trim().split(" ");
            int v1 = Integer.parseInt(input[0]);
            int v2 = Integer.parseInt(input[1]);
            int value = Integer.parseInt(input[2]);

            pq.add(new Edge(v1, v2, value));
        }

        while (mst.size() < (V - 1)){
            Edge edge = pq.poll();

            if(find(edge.start) != find(edge.end)){
                mst.add(edge);
                union(edge.start, edge.end);
            }
        }

        res = 0;
        for (int i = 0; i < mst.size(); i++) {
            res += mst.get(i).value;
        }
        System.out.println(res);
    }

    static int find(int n){
        if(n == arr[n]){
            return n;
        }else{
            int p = find(arr[n]);
            arr[n] = p;
            return p;
        }
    }

    static void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 != p2){
            arr[p1] = p2;
        }
    }

    static class Edge implements Comparable<Edge>{
        int start, end, value;

        Edge(int start, int end, int value){
            this. start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }
}
