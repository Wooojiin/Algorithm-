package programmers;

// 전화번호 목록

public class Solution42577 {
    public static void main(String[] args) {
//        String[] phone_book = {"119", "97674223", "1195524421"};/
        String[] phone_book = {"123","456","789"};

        System.out.println(solution(phone_book));
    }

    static boolean solution(String[] phone_book) {
        int len = phone_book.length;

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                String first = phone_book[i];
                String second = phone_book[j];

                if(first.startsWith(second))
                    return false;

                if(second.startsWith(first))
                    return false;
            }
        }
        return true;
    }
}
