package programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;

// 프린터

public class Solution42587 {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }

    static int solution(int[] priorities, int location) {
        int answer = 1;
        int length = priorities.length;

        LinkedList<Work> list = new LinkedList<>();
        PriorityQueue<Work> pq = new PriorityQueue<>();

        for (int i = 0; i < length; i++) {
            Work work = new Work(i, priorities[i]);
            pq.add(work);
            list.add(work);
        }

        while(true){
            Work now = list.removeFirst();

            if(now.priority == pq.peek().priority){
                pq.poll();

                if(now.index == location){
                    return answer;
                }
                answer++;
            }else {
                list.add(now);
            }
        }
    }

    static class Work implements Comparable<Work>{
        int index, priority;

        Work(int index, int priority){
            this.index = index;
            this.priority = priority;
        }

        @Override
        public int compareTo(Work o) {
            return o.priority - this.priority;
        }
    }
}
