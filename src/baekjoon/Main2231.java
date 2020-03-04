package baekjoon;

import java.util.Scanner;

public class Main2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        int digitNumber = 0;
        int tmpNumber = number;

        while(tmpNumber != 0){
            tmpNumber /= 10;
            digitNumber++;
        }

        int startNumber = number - digitNumber * 9;
        int result = 0;
        for (int i = startNumber; i <= number; i++) {
            int sum = i;
            String now = i + "";

            for (int j = 0; j < now.length(); j++) {
                sum += (now.charAt(j) - '0');
            }
            if(sum == number){
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
