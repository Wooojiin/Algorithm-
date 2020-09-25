package programmers;

// 2016년
public class Solution12901 {
    static int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

    public static void main(String[] args) {
        int month = 5;
        int day = 24;

        System.out.println(solution(month, day));
    }

    static String solution(int month, int day) {
        int count = 0;
        for(int i = 0; i < month - 1; i++){
            count += months[i];
        }

        count += (day - 1);

        return days[count % 7];
    }
}
