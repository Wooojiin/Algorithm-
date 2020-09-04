package programmers;

// 문자열 내 p와 y의 개수

public class Soluition12916 {
    public static void main(String[] args) {
        String s = "pPoooYy";

        System.out.println(solution(s));
    }

    static boolean solution(String s) {
        char[] arr = s.toCharArray();

        int size = arr.length;
        int count = 0;

        for (int i = 0; i < size; i++) {
            char now = arr[i];

            if(now == 'y' || now == 'Y'){
                count++;
            }else if(now == 'p' || now == 'P'){
                count--;
            }
        }

        return count == 0;
    }
}
