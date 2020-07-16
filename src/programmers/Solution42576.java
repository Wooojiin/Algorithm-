package programmers;

import java.util.HashMap;

// 완주하지 못한 선수

public class Solution42576 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};;

        System.out.println(solution(participant, completion));
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        int pLength = participant.length;
        int cLength = completion.length;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < pLength; i++) {
            String now = participant[i];
            if(map.containsKey(now)){
                map.put(now, map.get(now) + 1);
            }else{
                map.put(now, 1);
            }
        }

        for (int i = 0; i < cLength; i++) {
            String now = completion[i];
            if(map.containsKey(now) && map.get(now) == 1){
                map.remove(now);
            }else if(map.containsKey(now) && map.get(now) != 1){
                map.put(now, map.get(now) - 1);
            }
        }
        for (String name : map.keySet()) {
            answer = name;
        }
        return answer;
    }
}
