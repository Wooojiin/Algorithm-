package programmers;

// 다음 큰 숫자
public class Solution12911 {

    public static void main(String[] args) {
        int n = 78;

        System.out.println(solution(n));
    }

    static int solution(int n) {
        int answer = 0;
        String binaryString = Integer.toBinaryString(n);
        char[] binary = binaryString.toCharArray();

        int zeroPos = -1;
        int onePos = -1;
        int size = binary.length;

        for (int i = 0; i < size; i++) {
            if(binary[i] == '0'){
                zeroPos = i;
                break;
            }
        }

        if(zeroPos == -1){
            answer = Integer.parseInt("10" + binaryString.substring(1), 2); // 전부 1인 경우
        }else{
            for (int i = zeroPos; i < size; i++) {
                if(binary[i] == '1'){
                    onePos = i;
                    break;
                }
            }
            if(onePos == -1){
                answer = Integer.parseInt(binaryString + "0", 2);
            }else{
                int oneMovePos = zeroPos;
                for (int i = onePos; i >= zeroPos ; i--) {
                    if(binary[i] == 0){
                        oneMovePos = i;
                        break;
                    }
                }
                binary[oneMovePos] = '1';
                binary[onePos] = '0';
                answer = Integer.parseInt(new String(binary), 2);
            }
        }
        return answer;
    }
}
