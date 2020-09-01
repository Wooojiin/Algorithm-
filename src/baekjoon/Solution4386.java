package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

// 별자리 만들기

public class Solution4386 {
    static int V, E;
    static int[] arr;
    static ArrayList<Edge> mst;
    static PriorityQueue<Edge> pq;
    static double res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine().trim());
        E = (V * (V - 1)) / 2;

        double[][] inputs = new double[V + 1][2];
        arr = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            arr[i] = i;
            String[] input = br.readLine().trim().split(" ");

            double x = Double.parseDouble(input[0]);
            double y = Double.parseDouble(input[1]);

            inputs[i][0] = x;
            inputs[i][1] = y;
        }

        pq = new PriorityQueue<>();

        for (int i = 1; i <= V; i++) {
            for (int j =  i + 1; j <= V; j++) {
                int start = i;
                int end = j;
                double value = calDistance(inputs[i][0], inputs[i][1], inputs[j][0], inputs[j][1]);

                pq.add(new Edge(start, end, value));
            }
        }
        mst = new ArrayList<>();
        while (mst.size() < (V - 1)){
            Edge edge = pq.poll();

            if(find(edge.start) != find(edge.end)){
                mst.add(edge);
                union(edge.start, edge.end);
            }
        }

        res = 0.0;
        int size = mst.size();
        for (int i = 0; i < size; i++) {
            res += mst.get(i).value;
        }

        System.out.println(String.format("%.2f", res));

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

    static double calDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    static class Edge implements Comparable<Edge>{
        int start, end;
        double value;

        Edge(int start, int end, double value){
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.value == o.value){
                return 0;
            }else if(this.value > o.value){
                return 1;
            }else{
                return -1;
            }
        }
    }
}