import java.util.*;
import java.io.*;

class Main{
    static boolean[][] board;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        board = new boolean[n][m];
        for(int i=0; i<n; i++){
            str = br.readLine().split("");
            for(int j=0; j<m; j++){
                if(str[j].equals("B")){
                    board[i][j] = true;
                }
                else
                    board[i][j] = false;
            }

        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<n-7; i++){
            for(int j=0; j<m-7; j++){
                min = Math.min(min, bf(i,j ,true));
                min = Math.min(min, bf(i,j,false));
            }
        }
        System.out.println(min);
    }
    public static int bf(int x, int y, boolean flag){
        boolean cur;
        if(flag){
            cur = board[x][y];
        }
        else
            cur = !board[x][y];
        int count=0;
        for(int i=x; i<x+8; i++){
            for(int j=y; j<y+8; j++){
                if(board[i][j] != cur){
                    count++;
                }
                cur = !cur;
            }
            cur = !cur;
        }
        return count;
    }
}
