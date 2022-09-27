import java.io.*;
import java.util.*;

public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	static int[] dr = {0,0,-1,-1,-1,0, 1,1,1};
	static int[] dc = {0,-1,-1,0, 1,1, 1,0,-1 };
	static List<int[]> list = new ArrayList<>();
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		//이동은 n넘어가면 다시 1로 돌아오는데
		//대각선 길이 1 조사할때는 빠진다
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		
		list.add(new int[] {n-1, 0});
		list.add(new int[] {n-1, 1});
		list.add(new int[] {n-2, 0});
		list.add(new int[] {n-2, 1});
		
		for(int i=0; i<m; i++) {
			str = br.readLine().split(" ");
			int dir = Integer.parseInt(str[0]);
			int s = Integer.parseInt(str[1]);
			visited = new boolean[n][n];
			move(dir, s);
			rain();
			copyBug();
			list.clear();
			makeCloud();
		}
		
		int answer=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				answer += map[i][j];
			}
		}
		
		
		System.out.println(answer);
		
		
	}
	public static void copyBug() {
		for(int[] arr : list) {
			int r = arr[0];
			int c = arr[1];
			int diagonal = 0;
			
			for(int i=2; i<dr.length; i+=2) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nr >= n || nc < 0 || nc >=n) continue;
				
				if(map[nr][nc] > 0 ) diagonal++;
			}
			
			map[r][c] += diagonal;
		}
		
		
	}
	public static void print() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public static void makeCloud() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!visited[i][j] && map[i][j] >= 2) {
					//구름 추가
					list.add(new int[] {i,j});
					map[i][j] -= 2;
				}
			}
		}
		
	}
	public static void rain() {
		for(int[] arr : list) {
			int r = arr[0];
			int c = arr[1];
			
			map[r][c]++;
		}
	}
	public static void move(int dir, int s) {
		List<int[]> temp = new ArrayList<>();
		int plusR = (dr[dir]*s) % n;
		int plusC = (dc[dir]*s) % n;
		for(int[] arr : list) {
			int nr = (arr[0] + plusR)%n; 
			int nc = (arr[1] + plusC)%n;
			
			if(nr < 0) {
				nr = nr + n;
			}
			if(nc < 0) {
				nc = nc + n; 
			}
			
			//System.out.println("nr :"+nr+"nc :"+nc);
			visited[nr][nc] = true;
			temp.add(new int[] {nr,nc});
			
		}
		list = temp;
	}
}
