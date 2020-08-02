package challenge;

public class Main1 {
    static String P = "00000000000000000000";
    static String S = "91919191919191919191";

    public static void main(String[] args) {

        System.out.println(solution(P,S));
    }
    public static int solution(String p, String s) {
        int answer = 0;

        int len = p.length();
        int idx = 0;

        int diff, back;

        while (idx < len) {
            diff = P.charAt(idx) - S.charAt(idx);

            // 현재 눈금이 더 큰 경우
            if (diff > 0) {
                back = 10 - diff;
                answer = (back - diff) < 0 ? answer + back : answer + diff;
            }
            // 현재 눈금이 더 작은 경우
            else if (diff < 0) {
                back = 10 + diff;
                answer = (back + diff) > 0 ? answer - diff : answer + back;
            }
            idx++;
        }

        return answer;
    }
}
