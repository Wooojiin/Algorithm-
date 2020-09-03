package programmers;

import java.util.ArrayList;
import java.util.HashMap;

// 오픈채팅방

public class Solution42888 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] anwser = solution(record);

        for (String msg : anwser) {
            System.out.println(msg);
        }
    }

    static String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayList<Message> list = new ArrayList<>();

        int length = record.length;

        for (int i = 0; i < length; i++) {
            String[] input = record[i].split(" ");

            if(input[0].equals("Enter")){
                map.put(input[1], input[2]);
                list.add(new Message(input[1], true));
            }else if(input[0].equals("Leave")){
                list.add(new Message(input[1], false));
            }else{  // change
                map.replace(input[1], input[2]);
            }
        }

        int size = list.size();
        String[] answer = new String[size];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.setLength(0);

            Message now = list.get(i);
            String nickname = map.get(now.id);

            sb.append(nickname);
            if(now.type){
                sb.append("님이 들어왔습니다.");
            }else{
                sb.append("님이 나갔습니다.");
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

    static class Message{
        String id;
        boolean type;   // enter : true , leave : false

        Message(String id, boolean type){
            this.id = id;
            this.type = type;
        }
    }
}
