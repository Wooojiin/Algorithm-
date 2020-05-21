package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main10974 {

    static boolean[] visit;
    static List<String> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        visit = new boolean[num + 1];
        list = new LinkedList<>();

        perm(0, num);

    }

    static public void perm(int now, int limit){

        if(now == limit){
            StringBuilder sb = new StringBuilder();

            for (String number : list) {
                sb.append(number + " ");
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = 1; i <= limit; i++) {
            if(!visit[i]){
                visit[i] = true;
                list.add(i + "");
                perm(now + 1, limit);
                visit[i] = false;
                list.remove(i + "");
            }
        }
    }
}
