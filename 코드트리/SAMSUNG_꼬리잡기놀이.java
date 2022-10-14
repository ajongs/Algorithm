import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static int m;
	static int k;
	static int[][] map;
	static int[][] teamIdx;
	static int[] tail; // tail까지의 거리 offset
	static boolean[][] visited;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<Pos>[] v;
	static int ans=0;
	static class Pos{
		int r;
		int c;
		Pos(int r, int c){
			this.r=r;
			this.c=c;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		k = Integer.parseInt(str[2]);
		map = new int[n+1][n+1];
		teamIdx = new int[n+1][n+1];
		v = new ArrayList[m+1];
		for(int i=1; i<=m; i++) {
			v[i] = new ArrayList<>();
		}
		
		int cnt =1;
		for(int i=1; i<n+1; i++) {
			str = br.readLine().split(" ");
			for(int j=1; j<n+1; j++) {
				if(str[j-1].equals("0")) continue;
				map[i][j] = Integer.parseInt(str[j-1]);
				if(map[i][j] == 1)
					v[cnt++].add(new Pos(i,j));
			}
		}
		init();
		/*
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(teamIdx[i][j]+" ");
			}
			System.out.println();
		}*/
		/*
		for(Pos cur : v[0]) {
			System.out.println(cur.r+" , "+cur.c);
		}*/
		for(int i=1; i<=k; i++) {
			move();
			int idx = throwBall(i);
			reverse(idx);
		}
		/*
		for(Pos cur : v[2]) {
			System.out.println(cur.r+" , "+cur.c);
		}
		reverse(2);
		System.out.println("-=----------------------");
		for(Pos cur : v[2]) {
			System.out.println(cur.r+" , "+cur.c);
		}*/
		System.out.println(ans);
	}
	static int throwBall(int round) {
		int dir = (round-1) % (4*n) + 1;
		
		if(dir <= n) {
			for(int i=1; i<=n; i++) {
				if(1 <= map[dir][i] && map[dir][i] <= 3) {
					getPoint(dir, i);
					return teamIdx[dir][i];
				}
			}
		}else if(dir <= 2*n) {
			dir -= n;
			for(int i=n; i>=1; i--) {
				if(1 <= map[i][dir] && map[i][dir] <= 3) {
					getPoint(i, dir);
					return teamIdx[i][dir];
				}
			}
		}else if(dir<=3*n) {
			dir -= (2*n);
			for(int i=n; i>=1; i--) {
				if(1 <= map[n+1-dir][i] && map[n+1-dir][i] <= 3) {
					getPoint(n+1-dir,i);
					return teamIdx[n+1-dir][i];
				}
			}
		}else {
			dir -= (3*n);
			for(int i=1; i<=n; i++) {
				if(1 <= map[i][n+1-dir] && map[i][n+1-dir] <= 3) {
					getPoint(i,n+1-dir);
					return teamIdx[i][n+1-dir];
				}
			}
		}
		return 0; //공이 그대로 지나감
	}
	static void getPoint(int r, int c) {
		//System.out.println(r+", "+c);
		int cnt=1;
		for(Pos cur : v[teamIdx[r][c]]) {
			if(cur.r == r && cur.c == c) {
				break;
			}
			cnt++;
		}
		ans += cnt * cnt;
	}
	static void reverse(int idx) {
		if(idx ==0) return; //아무도 공 못받음 
		
		ArrayList<Pos> temp = new ArrayList<>();
		
		for(int i = tail[idx]-1; i>=0; i--) {
			temp.add(v[idx].get(i));
		}
		for(int i = v[idx].size()-1; i>=tail[idx]; i--) {
			temp.add(v[idx].get(i));
		}
		v[idx] = temp;
		
		for(int j=0; j<tail[idx]; j++) {
			Pos cur = v[idx].get(j);
			if(j==0) { //맨 처음 노드
				map[cur.r][cur.c] = 1;
			}else if(j!=tail[idx]-1) {
				map[cur.r][cur.c] = 2;
			}else {
				map[cur.r][cur.c] = 3;
			}
		}
	}
	static void move() {
		for(int i=1; i<=m; i++) {
			int lastIdx = v[i].size()-1;
			Pos temp = v[i].get(lastIdx); //가장 마지막인덱스가 옮길 인덱스
			for(int j=lastIdx; j>0; j--) {
				
				v[i].set(j, v[i].get(j-1));
			}
			v[i].set(0, temp);
		}
		
		//map에도 변경 반영하기
		for(int i=1; i<=m; i++) {
			for(int j=0; j<v[i].size(); j++) {
				Pos cur = v[i].get(j);
				if(j==0) {
					map[cur.r][cur.c] = 1;
				}else if(j < tail[i] -1 ) {
					map[cur.r][cur.c] = 2;
				}else if(j == tail[i] - 1) {
					map[cur.r][cur.c] = 3;
				}else
					map[cur.r][cur.c] = 4;
			}
		}
	}
	static void init() {
		visited = new boolean[n+1][n+1];
		tail = new int[m+1];
		for(int i=1; i<=m; i++) {
			dfs(v[i].get(0).r, v[i].get(0).c, i);
		}
	}
	static void dfs(int r, int c, int idx) {
		visited[r][c] = true;
		teamIdx[r][c] = idx;
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<1 || nr >= n+1 || nc <1 || nc>=n+1 || visited[nr][nc]) continue;
			if(map[nr][nc]==0) continue;
			if(v[idx].size()==1 && map[nr][nc] != 2) continue; //처음은 무조건 2 있는데로 가도록 함 
			
			v[idx].add(new Pos(nr,nc));
			if(map[nr][nc] == 3) tail[idx] = v[idx].size();
			dfs(nr,nc,idx);
		}
	}
}
