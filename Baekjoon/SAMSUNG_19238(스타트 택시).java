import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int m;
	static int fuel;
	static int[][] map;
	static int tr;
	static int tc;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<Passenger> list = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		fuel = Integer.parseInt(str[2]);
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				if(str[j].equals("1"))
					map[i][j] = 1;
			}
		}
		
		str=br.readLine().split(" ");
		tr = Integer.parseInt(str[0])-1;
		tc = Integer.parseInt(str[1])-1;
		
		for(int i=0; i<m; i++) {
			str = br.readLine().split(" ");
			int r = Integer.parseInt(str[0])-1;
			int c = Integer.parseInt(str[1])-1;
			int desR = Integer.parseInt(str[2])-1;
			int desC = Integer.parseInt(str[3])-1;
			list.add(new Passenger(r,c,desR,desC));
		}
		Collections.sort(list);
		
		
		
		
		for(int i=0; i<m; i++) {
			int idx = driveToMinPassenger();
			if(idx==-1 || !driveToDestination(idx)) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(fuel);
	}
	static boolean driveToDestination(int idx) {
		Passenger cur = list.remove(idx);
		
		int dis = bfs(cur.r, cur.c, cur.des_r, cur.des_c);
		
		//택시 이동
		tr = cur.des_r;
		tc = cur.des_c;
		fuel -= dis;
		if(fuel < 0) return false;
		fuel += dis*2;
		return true;
	}
	static int driveToMinPassenger() {
		int min = Integer.MAX_VALUE;
		int minIdx = -1;
		
		
		for(int i=0; i<list.size(); i++) {
			Passenger cur = list.get(i);
			int result = bfs(tr, tc, cur.r, cur.c);
			if(result == -1) return -1; //길이 다막힌경우 못감
			if(result < min) {
				min = result;
				minIdx = i;
			}
		}
		//손님위치로 택시 이동 
		tr = list.get(minIdx).r;
		tc = list.get(minIdx).c;
		fuel -= min;
		
		return minIdx;
	}
	static int bfs(int r, int c, int desR, int desC) {
		//System.out.println(r+","+c+" "+desR+","+desC);
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {r,c});
		visited[r][c] = true;
		
		int dis=0;
		while(!q.isEmpty()) {
			int size = q.size();
			
			while(size-- >0) {
				int[] cur = q.poll();
				
				if(cur[0]==desR && cur[1] == desC) return dis;
				for(int i=0; i<4; i++) {
					int nr = cur[0] + dr[i];
					int nc = cur[1] + dc[i];
					
					if(nr<0 || nr >= n || nc <0 || nc >=n || visited[nr][nc]) continue;
					if(map[nr][nc] == 1) continue;
					visited[nr][nc] = true;
					q.offer(new int[] {nr,nc});
				}
			}
			dis++;
		}
		
		return -1;
	}
	static private class Passenger implements Comparable<Passenger>{
		int r;
		int c;
		int des_r;
		int des_c;
		
		Passenger(int r,int c,int des_r, int des_c){
			this.r=r;
			this.c=c;
			this.des_c=des_c;
			this.des_r=des_r;
		}
		
		public int compareTo(Passenger o1) {
			if(this.r == o1.r) {
				return this.c - o1.c;
			}
			return this.r-o1.r;
		}
	}
}
