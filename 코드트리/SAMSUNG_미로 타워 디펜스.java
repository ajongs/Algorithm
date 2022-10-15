import java.io.*;
import java.util.*;
public class Main {

	static int n;
	static int m;
	static int[][] map;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {-1,0,1,0};
	//static int[] mr = {0,-1,1,0,0}; //마법 시전 방향 
	//static int[] mc = {0,0,0,-1,1};
	static int[] mr = {0,1,0,-1}; //마법 시전 방향 
	static int[] mc = {1,0,-1,0};
	static int sr;
	static int sc;
	static int answer=0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		map = new int[n+1][n+1];
		sr = (n+1)/2;
		sc = (n+1)/2;
		for(int i=1; i<=n; i++) {
			str = br.readLine().split(" ");
			for(int j=1; j<=n; j++) {
				int num = Integer.parseInt(str[j-1]);
				if(num >= 1) {
					map[i][j] = num;
				}
			}
		}
		
		for(int i=0; i<m; i++) {
			str = br.readLine().split(" ");
			int d = Integer.parseInt(str[0]);
			int s = Integer.parseInt(str[1]);
			magic(d,s);
			ArrayList<Integer> arr = explode();
			change(arr);
		}
		/*
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n ;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}*/
		System.out.println(answer);
	}
	public static void change(ArrayList<Integer> arr) {
		ArrayList<Integer> temp = new ArrayList<>();
		// 2 1
		// 2 2
		int std= arr.get(0);
		int cnt=1;
		for(int i=1; i<arr.size()+1; i++) {
			if(i == arr.size()) {
				temp.add(cnt);
				temp.add(std);
				break;
			}
			if(std != arr.get(i)) { //다를 
				temp.add(cnt);
				temp.add(std);	
				std = arr.get(i);
				cnt = 1;
			}
			else { //같을 때 
				cnt++;
			}
		}
		attach(temp);
	}
	public static ArrayList<Integer> explode() {
		//int[] arr = new int[n*n];
		ArrayList<Integer> arr = new ArrayList<>();
		
		int cnt=1;
		int double_cnt=0;
		int nr = sr;
		int nc = sc;
		int dir =0;
		while(true) {
			if(nr<1 || nr > n || nc<1 || nc > n) break;
			if(double_cnt == 2) {
				double_cnt = 0;
				cnt++;
			}
			for(int i=0; i<cnt; i++) {
				nr += dr[dir];
				nc += dc[dir];
				
				if(nr<1 || nr > n || nc<1 || nc > n) break;
				if(map[nr][nc]==-1) continue;
				arr.add(map[nr][nc]);
			}
			dir = (dir+1)%4;
			double_cnt++;
		}
		boolean isMore = true;
		while(isMore) {
			ArrayList<Integer> list = new ArrayList<>();
			
			int stdIdx = 0;
			int sameCnt = 1;
			isMore = false;
			for(int i=1; i<arr.size(); i++) {
				if(arr.get(stdIdx) != arr.get(i)) {
					if(sameCnt < 4) {
						for(int j=stdIdx; j<stdIdx+sameCnt; j++) {
							list.add(arr.get(j));
						}
					}
					else {
						isMore = true;
						answer += sameCnt * arr.get(stdIdx);
						//System.out.println(answer);
					}
					if(i==arr.size()-1) {
						list.add(arr.get(i));
					}
					
					stdIdx = i;
					sameCnt = 1;
					
				}
				else {
					sameCnt++;
					if(i==arr.size()-1 && sameCnt <4) {
						for(int j=stdIdx; j<stdIdx+sameCnt; j++) {
							list.add(arr.get(j));
						}
					}else if(i==arr.size()-1 && sameCnt >=4){
						isMore = true;
						answer += sameCnt * arr.get(stdIdx);
						//System.out.println(answer);
					}
				}
			}
			arr = list;
		}
		
		return arr;
		
	}
	public static void attach(ArrayList<Integer> list) {
		int cnt=1;
		int double_cnt=0;
		int nr = sr;
		int nc = sc;
		int dir =0;
		int idx=0;
		while(true) {
			if(nr<1 || nr > n || nc<1 || nc > n) break;
			if(double_cnt == 2) {
				double_cnt = 0;
				cnt++;
			}
			for(int i=0; i<cnt; i++) {
				nr += dr[dir];
				nc += dc[dir];
				
				if(nr<1 || nr > n || nc<1 || nc > n) break;
				if(idx < list.size()) {
					map[nr][nc] = list.get(idx++);
				}
				else 
					map[nr][nc] = 0;
			}
			dir = (dir+1)%4;
			double_cnt++;
		}
	}
	public static void magic(int d, int s) {
		int nr = sr;
		int nc = sc;
		while(s-- >0) {
			nr += mr[d];
			nc += mc[d];
			
			if(nr<1 || nr > n || nc<1 || nc > n) continue;
			answer += map[nr][nc];
			map[nr][nc] = -1; //삭제 
		}
	}

}
