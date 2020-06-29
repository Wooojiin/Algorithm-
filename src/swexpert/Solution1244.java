package swexpert;

import java.io.*;
import java.util.HashSet;

public class Solution1244 {
    static int max;
    static HashSet<String> check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= testCase; tc++) {
            String[] input = br.readLine().trim().split(" ");

            int[] arr = new int[input[0].length()];
            int change = Integer.parseInt(input[1]);

            for (int i = 0; i < input[0].length(); i++) {
                arr[i] = input[0].charAt(i) - '0';
            }

            check = new HashSet<>();
            max = 0;

            find(arr, change);

            bw.write("#" + tc + " " + max + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static void find(int[] arr, int change){
        int number = 0;

        for (int i = 0; i < arr.length; i++) {
            number = arr[i] + number * 10;
        }

        if(!check.add(change + " " + number)){
            return;     // 이미 똑같은 결과가 있다면 종료
        }

        if(change == 0){
            max = Math.max(max, number);    // 교환 완료후 값 비교
        }else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    swap(arr, i, j);
                    find(arr, change - 1);
                    swap(arr, i, j);    // 원래 위치로 이동
                }
            }
        }
    }
}
