package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 여행 가자

public class Solution1976 {
    static int scheduleLength;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine().trim());
        arr = new int[size + 1];

        scheduleLength = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= size; i++) {
            arr[i] = i;
        }
        
        for (int i = 1; i <= size; i++) {
            String[] input = br.readLine().trim().split(" ");

            for (int j = 1; j <= size; j++) {
                String now = input[j - 1];
                
                if(now.equals("1")){
                    int n1 = i;
                    int n2 = j;
                    
                    union(n1, n2);
                }
            }
        }
        String[] schedule = br.readLine().trim().split(" ");
        System.out.println(check(schedule));
    }

    static String check(String[] schedule){
        int now = find(Integer.parseInt(schedule[0]));

        for (int i = 1; i < scheduleLength; i++) {
            int next = find(Integer.parseInt(schedule[i]));

            if(now != next){
                return "NO";
            }
        }
        return "YES";
    }

    static int find(int n){
        if(n == arr[n])
            return n;

        int p = find(arr[n]);
        arr[n] = p;
        return p;
    }

    static void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 != p2){
            arr[p1] = p2;
        }
    }
}
