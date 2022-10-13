import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int m;
	static int k;
	static int c;
	static int[][] map;
	static int[][] blank;
	static int[][] plus;
	static int[][] paradox;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[] sr = {-1,1,1,-1};
	static int[] sc = {-1,1,-1,1};
	static int answer=0;
	public static void main(String[] args)throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		k = Integer.parseInt(str[2]);
		c = Integer.parseInt(str[3]);
		map = new int[n][n];
		paradox = new int[n][n];
		for(int i=0; i<n; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				if(!str[j].equals("0"))
					map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		for(int i=0; i<m; i++) {
			grow();
			breeding();
			spray();
			disappear();
		}
		
		System.out.println(answer);
	}
	static void disappear() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(paradox[i][j] ==0) continue;
				paradox[i][j]--;
			}
		}
	}
	static void spray() {
		ArrayList<Pos> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 0 || map[i][j] == -1) continue;
				
				int count =map[i][j];
				
				for(int d=0; d<4; d++) {
					int repeat = k;
					
					int nr = i;
					int nc = j;
					while(repeat-- >0) {
						nr  += sr[d];
						nc  += sc[d];
						
						if(nr<0 || nr >=n || nc<0 || nc>=n) continue;
						if(map[nr][nc]<=0) break;
						count += map[nr][nc];
					}
					
				}
				list.add(new Pos(i,j,count));
			}
		}
		Collections.sort(list);
		if(list.size()==0) return;
		Pos max = list.get(0);
		paradox[max.r][max.c] = c+1;
		answer += map[max.r][max.c];
		map[max.r][max.c] = 0;
		for(int d=0; d<4; d++) {
			int repeat = k;
			
			int nr = max.r;
			int nc = max.c;
			while(repeat-- >0) {
				nr += sr[d];
				nc += sc[d];
				
				if(nr<0 || nr >=n || nc<0 || nc>=n) continue;
				paradox[nr][nc] = c+1; //제초제 뿌리기 
				if(map[nr][nc]==0 || map[nr][nc] == -1) break; //빈칸이거나 벽이면 더이상 ㄴ
				answer += map[nr][nc];
				map[nr][nc]=0; // 나무 제거 
			}
		}
	}
	static void breeding() {
		plus = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 0 || map[i][j] == -1) continue;
				
				for(int d=0; d<4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if(nr<0 || nr >=n || nc<0 || nc>=n) continue;
					if(map[nr][nc] ==0 && paradox[nr][nc]==0) {
						plus[nr][nc] += map[i][j]/blank[i][j];
					}
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(plus[i][j] == 0) continue;
				map[i][j] += plus[i][j];
			}
		}
	}
	static void grow() {
		plus = new int[n][n];
		blank = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j]==0 || map[i][j] == -1) continue;
				
				int count=0;
				int bcount=0;
				for(int d=0; d<4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					
					if(nr<0 || nr >=n || nc<0 || nc>=n) continue;
					if(map[nr][nc] ==0 && paradox[nr][nc]==0) bcount++;
					if(map[nr][nc]!=0 && map[nr][nc] != -1) count++; 
				}
				plus[i][j] = count;
				blank[i][j] = bcount;
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(plus[i][j] == 0) continue;
				map[i][j] += plus[i][j];
			}
		}
	}
	static class Pos implements Comparable<Pos>{
		int r;
		int c;
		int tree; //박멸나무 수
		Pos(int r, int c, int tree){
			this.r =r;
			this.c=c;
			this.tree= tree;
		}
		public int compareTo(Pos o1) {
			if(o1.tree == this.tree) {
				if(this.r == o1.r) {
					return this.c - o1.c;
				}
				return this.r - o1.r;
			}
			return o1.tree - this.tree;
		}
	}
}
