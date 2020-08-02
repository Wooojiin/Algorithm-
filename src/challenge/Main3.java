package challenge;

import java.util.*;

public class Main3 {


    public static void main(String[] args) {

        int[] input = {1, 11, 21, 31, 41, 51, 61, 71};

        for (int i = 0; i < input.length; i++)
            dfs(input, 5, i, 0);

        if (min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);
    }

    static int min = Integer.MAX_VALUE;
    static HashMap<String, Integer> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    static int solution(int[] numbers, int K){
        int answer = -1;

        map.put(makeStr(numbers), 0);
        for (int i = 0; i < numbers.length - 1; i++) {
            dfs(numbers, K, i, 0);
        }

        if (min != Integer.MAX_VALUE)
            answer = min;

        return answer;
    }

    static void dfs(int[] numbers, int K, int index, int change) {

        if (change >= min) {
            return;
        }

        boolean isDone = true;
        for (int i = 1; i < numbers.length; i++) {
            if (Math.abs(numbers[i] - numbers[i - 1]) > K) {
                isDone = false;
                break;
            }
        }

        if (isDone) {
            min = change < min ? change : min;
            return;
        }

        // 종료 조건
        if (index == numbers.length) {
            return;
        }

        // swap
        int tmp = numbers[index];
        for (int i = index + 1; i < numbers.length; i++) {

            numbers[index] = numbers[i];
            numbers[i] = tmp;

            String now = makeStr(numbers);
            if (map.containsKey(now)) {
                int value = map.get(now);
                if (change + 1 < value) {
                    map.put(now, change + 1);
                    dfs(numbers, K, index + 1, change + 1);
                }
            } else {
                dfs(numbers, K, index + 1, change + 1);
            }

            numbers[i] = numbers[index];
            numbers[index] = tmp;
        }
    }

    static String makeStr(int[] array){
        sb.setLength(0);

        for (int n = 0; n < array.length; n++) {
            sb.append(array[n]);
        }
        return sb.toString();
    }
}