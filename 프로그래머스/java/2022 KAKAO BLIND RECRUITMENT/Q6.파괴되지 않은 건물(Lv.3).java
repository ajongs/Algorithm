class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] d = new int[1001][1001];

        for(int i=0; i<skill.length; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            //적 공격 -
            if(type ==1 ) degree = -degree;
            d[r1][c1] += degree;
            d[r1][c2+1] -= degree;
            d[r2+1][c1] -= degree;
            d[r2+1][c2+1] += degree;
        }

        //왼쪽에서 오르쪽으로 누적합

        for(int i=0; i<n; i++){
            for(int j=1; j<m; j++){
                d[i][j] += d[i][j-1];
            }
        }

        //위에서 아래로 누적합
        for(int i=1; i<n; i++){
            for(int j=0; j<m; j++){
                d[i][j] += d[i-1][j];
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] += d[i][j];
                if(board[i][j] > 0) answer++;
            }
        }

        return answer;
    }
}
