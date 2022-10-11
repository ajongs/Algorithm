import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	static ArrayList<Fireball>[][] map;
	static int n;
	static int m;
	static int k;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]); //파이어볼 개수
		k = Integer.parseInt(str[2]);
		map = new ArrayList[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		//파이어볼 현재 위치 초기화 
		for(int i=0; i<m; i++) {
			str = br.readLine().split(" ");
			
			int ri = Integer.parseInt(str[0])-1;
			int ci = Integer.parseInt(str[1])-1;
			int mi = Integer.parseInt(str[2]);
			int si = Integer.parseInt(str[3]);
			int di = Integer.parseInt(str[4]);
			
			map[ri][ci].add(new Fireball(ri,ci,mi,si,di));
			
		}

		
		for(int i=0; i<k; i++) {
			move();
			combine();
		}
		
		/*
		for(int k=0; k<4; k++) {
			Fireball cur = map[0][2].get(k);
			
			System.out.println(cur.r+" "+cur.c+" "+cur.m+" "+ cur.s+" "+cur.d);
		}*/
		
		/*
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(map[i][j].size()+"\t");
				
				if(map[i][j].size() >= 1) {
					Fireball cur = map[i][j].get(0);
					System.out.println(cur.r+" "+cur.c+" "+cur.m+" "+ cur.s+" "+cur.d);
				}
			}
			System.out.println();
		}*/
		System.out.println(sumM());
	}
	static int sumM() {
		int answer=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int size = map[i][j].size(); 
				if(size >= 1) {
					for(int k=0; k<size; k++) {
						Fireball cur = map[i][j].get(k);
						
						answer += cur.m;
					}
				}
			}
		}
		return answer;
	}
	static void combine() {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j].size() >= 2) {
					Fireball cur = map[i][j].get(0);
					
					int m = cur.m;
					int s = cur.s;
					int d = cur.d % 2;
					boolean isEven = true;
					
					for(int k=1; k<map[i][j].size(); k++) {
						Fireball next  = map[i][j].get(k);
						
						m += next.m;
						s += next.s;
						if(isEven && (next.d%2) != d)
							isEven = false;
					}
					
					//질량이 0인경우는 파이어볼 소멸 
					if(m/5==0) {
						map[i][j].clear();
						continue;
					}
					m /= 5;
					s /= map[i][j].size();
					map[i][j].clear();
					for(int k=0; k<8; k++) {
						if(isEven) {
							if(k % 2==0)
								map[i][j].add(new Fireball(i,j,m,s,k));
						}
						else {
							if(k % 2==1)
								map[i][j].add(new Fireball(i,j,m,s,k));	
						}
					}
				}
			}
		}
	}
	static void move() {
		ArrayList<Fireball>[][] temp = new ArrayList[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				temp[i][j] = new ArrayList<>();
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j].size() >= 1) {
					for(int k=0; k<map[i][j].size(); k++) {
						Fireball cur = map[i][j].get(k);
						
						int s = cur.s % n;
						int nr = (cur.r + (dr[cur.d] * s + n)%n)%n;
						int nc = (cur.c + (dc[cur.d] * s + n)%n)%n;
						
						cur.r = nr;
						cur.c = nc;
						temp[nr][nc].add(cur);	
					}
					map[i][j].clear();
				}
			}
		}
		map = temp;
	}
	static private class Fireball{
		int r;
		int c;
		int m;
		int d;
		int s;
		
		public Fireball(int r, int c, int m, int s, int d){
			this.r =r;
			this.c =c;
			this.m =m;
			this.d =d;
			this.s =s;
		}
	}
}

