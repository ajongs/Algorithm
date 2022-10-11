import java.io.*;
import java.util.*;
public class Main {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int n;
	static int m;
	static int k;
	static int[][] map;
	static LinkedList<Integer> rowDice = new LinkedList<>();
	static LinkedList<Integer> colDice = new LinkedList<>();
	static int score=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		k = Integer.parseInt(str[2]);
		map = new int[n][m];
		diceInit();
		
		for(int i=0; i<n; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		move(0,0,0,k);
		System.out.println(score);
	}
	static void diceInit() {
		rowDice.addLast(4);
		rowDice.addLast(1);
		rowDice.addLast(3);
		
		colDice.addLast(2);
		colDice.addLast(1);
		colDice.addLast(5);
		colDice.addLast(6);
	}
	static void move(int r, int c, int d, int k) {
		if(k == 0) return;
		int nr = r+dr[d];
		int nc = c+dc[d];
		
		if(nr<0 || nr >= n || nc <0 || nc >= m) {
			d = (d+2)%4;
			move(r,c,d,k);
			return;
		}
			
		
		//주사위 바닥면도 갱신 
		if(d==0) { //동
			rowDice.addFirst(colDice.removeLast());
			colDice.addLast(rowDice.removeLast());
			colDice.remove(1);
			colDice.add(1, rowDice.get(1));
		}else if(d==1) { //남 
			colDice.addFirst(colDice.removeLast());
			rowDice.remove(1);
			rowDice.add(1, colDice.get(1));
		}else if(d==2) { //서 
			
			rowDice.addLast(colDice.removeLast());
			colDice.addLast(rowDice.removeFirst());
			colDice.remove(1);
			colDice.add(1, rowDice.get(1));
		}else { //북 
			colDice.addLast(colDice.removeFirst());
			rowDice.remove(1);
			rowDice.add(1, colDice.get(1));
		}
		visited = new boolean[n][m];
		visited[nr][nc] = true;
		getScore(nr, nc, map[nr][nc]);
		d = compare(colDice.get(3), map[nr][nc], d);
		move(nr,nc,d,k-1);
			
	}
	static boolean[][] visited;
	static void getScore(int r, int c, int num) {
		if(num != map[r][c]) return;
		score += num;
		
		
		for(int i=0; i<4; i++) {
			int nr = r+ dr[i];
			int nc = c+ dc[i];
			
			if(nr <0 || nr >= n || nc <0 || nc>=m || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			getScore(nr,nc,num);
		}
			
	}
	static int compare(int bottom, int mapNum, int d) {
		if(bottom > mapNum) {
			d = (d+1)%4;
		}
		else if(bottom < mapNum) {
			d = (d-1+4)%4;
		}
		return d;
	}
}
