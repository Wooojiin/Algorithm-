package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// CCW

public class Solution11758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Point[] arr = new Point[3];

        for (int i = 0; i < 3; i++) {
            String[] input = br.readLine().trim().split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            arr[i] = new Point(x, y);
        }

        int value = (arr[0].x * arr[1].y) + (arr[1].x * arr[2].y) + (arr[2].x * arr[0].y)
                - (arr[0].x * arr[2].y) - (arr[1].x * arr[0].y) - (arr[2].x * arr[1].y);

        if(value > 0)
            System.out.println("1");
        else if(value < 0)
            System.out.println("-1");
        else
            System.out.println("0");
    }

    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
