package programmers;

// 모의고사
public class Solution42840 {

    static int score1, score2, score3;
    static int[] person1 = {1,2,3,4,5};
    static int[] person2 = {2,1,2,3,2,4,2,5};
    static int[] person3 = {3,3,1,1,2,2,4,4,5,5};

    public static void main(String[] args) {
        int[] arr = {1,3,2,4,2};

        int[] res = solution(arr);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }

    static int[] solution(int[] answers) {
        int size = answers.length;
        boolean[] answer = new boolean[3];

        score1 = check(answers, size, person1);
        score2 = check(answers, size, person2);
        score3 = check(answers, size, person3);

        if(score1 > score2){
            answer[0] = true;
            if(score1 < score3){
                answer[0] = false;
                answer[2] = true;
            }else if(score1 == score3){
                answer[2] = true;
            }
        }else if(score1 == score2){
            answer[0] = answer[1] = true;
            if(score1 < score3){
                answer[0] = answer[1] = false;
                answer[2] = true;
            }else if(score1 == score3){
                answer[2] = true;
            }
        }else{
            answer[1] = true;
            if(score2 < score3){
                answer[1] = false;
                answer[2] = true;
            }else if(score2 == score3){
                answer[2] = true;
            }
        }
        int resSize = 0;
        for (int i = 0; i < 3; i++) {
            if(answer[i]){
                resSize++;
            }
        }

        int[] res = new int[resSize];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            if(answer[i]){
                res[index++] = i + 1;
            }
        }

        return res;
    }

    static int check(int[] answers, int size, int[] person){
        int count = 0;
        int repeatSize = person.length;

        for (int i = 0; i < size; i++) {
            if(answers[i] == person[i % repeatSize]){
                count++;
            }
        }
        return count;
    }
}
