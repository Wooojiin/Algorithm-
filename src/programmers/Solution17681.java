package programmers;

// 비밀지도

public class Solution17681 {
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] res = solution(n, arr1, arr2);

        for (String str : res) {
            System.out.println(str);
        }
    }

    static String[] solution(int n, int[] arr1, int[] arr2) {
        StringBuilder sb = new StringBuilder();
        String[] map = new String[n];
        String format = "%0" + n + "d";

        for (int i = 0; i < n; i++) {
            String str1 = String.format(format, Long.parseLong(Integer.toBinaryString(arr1[i])));
            String str2 = String.format(format, Long.parseLong(Integer.toBinaryString(arr2[i])));
            sb.setLength(0);

            for (int j = 0; j < n; j++) {
                char ch1 = str1.charAt(j);
                char ch2 = str2.charAt(j);

                if(ch1 == '0' && ch2 == '0'){
                    sb.append(" ");
                }else{
                    sb.append("#");
                }
            }
            map[i] = sb.toString();
        }
        return map;
    }
}
