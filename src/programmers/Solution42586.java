package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 기능 개발

public class Solution42586 {
    public static void main(String[] args) {

        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] sppeed = {1, 1, 1, 1, 1, 1};

        int[] answers = solution(progresses, sppeed);

        for (int answer : answers) {
            System.out.print(answer + " ");
        }
    }

    static int[] solution(int[] progresses, int[] speeds) {

        ArrayList<Integer> list = new ArrayList<>();
        int length = progresses.length;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < length; i++) {
            int remain = 100 - progresses[i];
            int speed = speeds[i];

            int days = remain / speed;
            if(remain % speed != 0){
                days += 1;
            }
            queue.add(days);
        }

        int now = !queue.isEmpty() ? queue.poll() : 0;
        int count = 1;

        while(!queue.isEmpty()){
            int poll = queue.poll();

            if(now >= poll){
                count++;
            }else{
                list.add(count);
                now = poll;
                count = 1;
            }
        }
        list.add(count);
        int size = list.size();
        int[] answer = new int[size];

        for (int i = 0; i < size; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
