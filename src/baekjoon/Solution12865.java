package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 평범한 배낭

public class Solution12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().trim().split(" ");
        int itemNum = Integer.parseInt(size[0]);
        int maxWeight = Integer.parseInt(size[1]);

        Item[] items = new Item[itemNum + 1];

        for (int i = 1; i <= itemNum; i++) {
            String[] input = br.readLine().trim().split(" ");

            int weight = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);

            items[i] = new Item(weight, value);
        }

        int[][] table = new int[itemNum + 1][maxWeight + 1];

        for (int i = 1; i <= itemNum; i++) {    // 아이템 번호
            for (int j = 1; j <= maxWeight; j++) {  // 가방 크기
                if(j < items[i].weight){
                    table[i][j] = table[i - 1][j];  // 못넣으면 이전것 그대로
                }else{
                    int value1 = table[i - 1][j];   // 현재 번호 물건 안넣은 상태
                    int value2 = table[i - 1][j - items[i].weight] + items[i].value;
                    table[i][j] = Integer.max(value1, value2);
                }
            }
        }

        System.out.println(table[itemNum][maxWeight]);

    }

    static class Item{
        int weight, value;

        Item(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }
}
