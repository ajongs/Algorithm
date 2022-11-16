import java.util.*;
import java.io.*;
class Solution
{
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
        
        for (int num = 0; num < n; num++) {
       
        	int count = 0;
        	char[][] board = new char[8][8];
        	ArrayList<int[]> points = new ArrayList<>();
        	for (int i = 0; i < 8; i++) {
        		String str = br.readLine();
        		for (int j = 0; j < 8; j++) {
        			char item = str.charAt(j);
        			if (item == 'O') {
        				count++;
        				points.add(new int[] {i, j});
        			}
        			board[i][j] = item;
        		}
        	}
        	if (count != 8) {
        		printResult(num, "no");
        		continue;
        	}
        	boolean answer = true;
        	for (int[] point : points) {
        		answer = search(point[0], point[1], board);
        		if (!answer) {
        			break;
        		}
        	}
        	if (!answer) {
    			printResult(num, "no");
    			continue;
    		}
        	printResult(num, "yes");
        }
	}
	public static boolean search(int sr, int sc, char[][] board) {
		for (int i = 0; i < 4; i++) {
			if (!goDirection(sr, sc, i, board)) {
				return false;
			}
		}
		return true;
		
	}
	public static boolean goDirection(int sr, int sc, int direction, char[][] board) {
		int nr = sr;
		int nc = sc;
		while (true) {
			nr += dr[direction];
			nc += dc[direction];
			
			if (nr < 0 || nr >= 8 || nc < 0 || nc >= 8) break;
			if (board[nr][nc] == 'O') {
				return false;
			}
		}
		return true;
	}
	public static void printResult(int num, String answer) {
		System.out.println("#" + (num + 1) + " " + answer); 
	}
	public static void print(char[][] board) {
		for (char[] b : board) {
			for (char item : b) {
				System.out.print(item);
			}
			System.out.println();
		}
	}
}
