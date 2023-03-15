class Solution {
    public int solution(String[] board) {
        char[][] map = new char[3][3];
        int oCount =0;
        int xCount =0;
        for(int i = 0; i < 3; i++) {
            for (int j =0 ; j< 3; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'O') {
                    oCount++;
                }
                else if (map[i][j] == 'X') {
                    xCount++;
                }
            } 
        }

        if (oCount < xCount || oCount - xCount > 1) return 0;

        int oWin = win('O', map);
        int xWin = win('X', map);

        if (oWin == -1 || xWin == -1) return 0;
        if (oWin==xWin && oWin == 1) return 0;
        if (oWin > 0 && oCount <= xCount) return 0;
        if (xWin > 0 && xCount < oCount) return 0;
        return 1;

    }
    public int win(char player, char[][] map) {
        int winCount = 0;
        for (int i = 0; i < 3; i++) {
            if (row3Check(player, map[i])) winCount++;
        }
        for (int i = 0; i < 3; i++) {
            if (col3Check(player, map, i)) winCount++;
        }
        if(cross3Check_rightDown(player, map)) winCount++;
        if(cross3Check_rightUp(player, map)) winCount++;

        if (winCount > 2) return -1;
        return winCount;
    }
    public boolean cross3Check_rightDown(char player, char[][] map) {
        for (int i =0 ; i< 3; i++) {
            if (map[i][i] != player) return false;
        }
        return true;
    }
    public boolean cross3Check_rightUp(char player, char[][] map) {
        //2,0 1,1, 0,2
        int r = 2;
        int c = 0;
        for (int i =0 ; i< 3; i++) {
            if(map[r--][c++] != player) return false;
        }
        return true;
    }
    public boolean col3Check(char player, char[][] map, int i) {
        for (int j = 0; j < 3; j++) {
            if(map[j][i] != player) return false;
        }
        return true;
    }
    public boolean row3Check(char player, char[] row) {
        for (int i = 0; i < 3; i++) {
            if (row[i] != player) return false;
        }
        return true;
    }
}
