package challenge;

public class Main2 {

    public static void main(String[] args) {
        int[][] office = {{5,-1,4}
                        ,{6,3,-1}
                        ,{2,-1,1}};

        int r = 1;
        int c = 0;

        String[] move = {"go","go","right","go","right","go","left","go"};


        System.out.println(solution(office, r, c , move));
    }
    static int[] di = {-1,0,1,0}; // clockwise
    static int[] dj = {0,1,0,-1};

    public static int solution(int[][] office, int firsti, int firstj, String[] move) {
        int answer = office[firsti][firstj]; // 먼지양
        office[firsti][firstj] = 0;

        int dir = 0;
        int nowi = firsti;
        int nowj = firstj;

        int isize = office.length;
        int jsize = office[0].length;

        for (int c = 0; c < move.length; c++) {
            String cmd = move[c];

            if(cmd.equals("go")){
                int nexti = nowi + di[dir];
                int nextj = nowj + dj[dir];

                if(nexti >= 0 && nexti < isize && nextj >= 0 && nextj < jsize && office[nexti][nextj] != -1){
                    nowi = nexti;
                    nowj = nextj;

                    answer += office[nowi][nowj];
                    office[nowi][nowj] = 0;
                }
            }else if(cmd.equals("left")){
                dir = dir == 0 ? 3 : (dir - 1);

            }else{
                dir =  dir == 3 ? 0 : (dir + 1);
            }
        }
        return answer;
    }
}


