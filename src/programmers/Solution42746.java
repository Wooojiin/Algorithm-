package programmers;

import java.util.Arrays;
import java.util.Comparator;

// 가장 큰 수

public class Solution42746 {
    public static void main(String[] args) {

        int[] numbers = {3, 30, 34, 5, 9};
        String[] str = {"3","51","30","34","91","5","9"};

        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {

        StringBuilder sb = new StringBuilder();

        int length = numbers.length;
        String[] strArray = new String[length];

        for (int i = 0; i < length; i++) {
            strArray[i] = numbers[i] + "";
        }

        Arrays.sort(strArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });

        if(strArray[length - 1].equals("0"))
            return "0";

        for (int i = length - 1; i >= 0; i--) {
            sb.append(strArray[i]);
        }

        return sb.toString();
    }
}
