package programmers.bruteForce;

public class Solution42842 {

    public static void main(String[] args) {
        int brown = 10;
        int yellow = 1;

        System.out.println(solution(brown, yellow));
    }

    static int[] solution(int brown, int yellow) {
        int[] answer = {};
        int bHeight, bWidth, yHeight = 1, yWidth = yellow;
        if(brown >= yWidth + 2 + 6){ // yellow 박스 한 줄 인 경우
            bHeight = 3;
            bWidth = yWidth + 2;
        }else{
            if(yWidth % 2 == 0){

            }else{

            }
        }

        return answer;
    }
}
