import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Fish>[][] map;
	static ArrayList<Fish> list;
	static int[][] smell;
	static int[] dr = { 0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dc = { -1,-1, 0, 1,	1, 1, 0, -1};
	static int[] shark_dr = {-1, 0, 1, 0};
	static int[] shark_dc = {0, -1, 0, 1};
	static int res; //정
	static int sharkR;
	static int sharkC;
	static int m;
	static int s;
	public static void main(String[] args) throws IOException, CloneNotSupportedException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		m = Integer.parseInt(str[0]);
		s = Integer.parseInt(str[1]);
		smell = new int[4][4];
		map = new ArrayList[4][4];
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		list = new ArrayList<>();
		
		for(int i=0; i<m; i++) {
			str = br.readLine().split(" ");
			int r = Integer.parseInt(str[0])-1;
			int c = Integer.parseInt(str[1])-1;
			int d = Integer.parseInt(str[2])-1;
			
			list.add(new Fish(r,c,d));
		}
		str = br.readLine().split(" ");
		sharkR = Integer.parseInt(str[0])-1;
		sharkC = Integer.parseInt(str[1])-1;
		
		simulation();
		System.out.println(res);
	}
	static void simulation() throws CloneNotSupportedException {
		//먼저 현재 리스트 안에있는거 임시로 받아놓기
		for(int time=0; time<s; time++) {
			ArrayList<Fish> copy = copy(list);
			//물고기 이동하고
			for(Fish cur : list) {
				moveFish(cur);
			}
			//map에 반영
			setMap();
			//상어가 물고기를 제일 많이 잡아먹을 경로
			fishNum = Integer.MIN_VALUE;
			sharkBackTracking(0);
			//찾은 경로로 이동하면서 물고기 없애고 냄새 남기기 
			moveShark();
			//물고기 냄새 1 줄어들기 
			removeSmell();
			//복제 마법 처리
			setCopyMap(copy);
			reset();
		}
	}
	static void printList() {
		for(Fish cur : list) {
			System.out.println(cur.r+", "+cur.c+" : "+cur.d);
		}
	}
	static void printMap() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				for(int k=0; k<map[i][j].size(); k++) {
					System.out.println(i+", "+j+" : "+map[i][j].get(k).d);
				}
			}
		}
	}
	static int[] result = new int[3];
	static int[] sharkMove = new int[3];
	static int fishNum = Integer.MIN_VALUE;
	static void reset() {
		list.clear();
		int cnt=0;
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				for(int k=0; k<map[i][j].size(); k++) {
					list.add(map[i][j].get(k));
					cnt++;
				}
				map[i][j].clear();
			}
		}
		res = cnt;
	}
	static void setCopyMap(ArrayList<Fish> copy){
		for(Fish cur : copy) {
			map[cur.r][cur.c].add(cur);
		}
	}
	static void removeSmell() {
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				if(smell[i][j] >0) smell[i][j]--;
			}
		}
	}
	static void moveShark() {
		//지나가면서 0으로 만들고 냄새 남기기
		for(int i=0; i<3; i++) {
			int d = sharkMove[i];
			
			sharkR += shark_dr[d];
			sharkC += shark_dc[d];
			
			if(map[sharkR][sharkC].size() > 0) {
				smell[sharkR][sharkC] = 3;
				map[sharkR][sharkC].clear();
			}
		}
	}
	static void sharkBackTracking(int index) {
		if(index == 3) {
			int fnum = checkFishNum();
			
			if(fnum == -1) return;
			if(fnum > fishNum) {
				fishNum = fnum;
				
				for(int i=0; i<3; i++) {
					sharkMove[i] = result[i];
				}
			}
			return;
		}
		for(int i=0; i<4; i++) {
			result[index] = i; //방향 조사
			sharkBackTracking(index+1);
		}
	}
	static int checkFishNum() {
		//result 보고 해당 방향으로 이동해보고 fish 개수 반환하고
		int fnum=0;
		boolean visited[][] = new boolean[4][4];
		int nr = sharkR;
		int nc = sharkC;
		
		for(int i=0; i<3; i++) {
			nr += shark_dr[result[i]];
			nc += shark_dc[result[i]];
			
			if(nr <0 || nr >= 4 || nc <0 || nc>=4) return -1;
			if(visited[nr][nc]) continue;
			visited[nr][nc] = true;
			fnum += map[nr][nc].size();
			
		}
		//만약 더 움직이지 못하는 경우는 -1을 반환하자 
		return fnum;
	}
	static void setMap() {
		for(Fish cur : list) {
			map[cur.r][cur.c].add(cur);
		}
	}
	static void moveFish(Fish cur) {
		for(int i=0; i<8; i++) {
			int d = (cur.d - i + 8) % 8;
			int nr = cur.r + dr[d];
			int nc = cur.c + dc[d];
			
			
			if(nr>=0 && nr < 4 && nc>=0 && nc <4) {
				if(smell[nr][nc] == 0 && !(nr == sharkR && nc == sharkC)) {
					cur.r = nr;
					cur.c = nc;
					cur.d = d;
					break;
				}
			}
		}
	}
	static ArrayList<Fish> copy(ArrayList<Fish> list) throws CloneNotSupportedException{
		ArrayList<Fish> temp = new ArrayList<>();
		for(Fish cur : list) {
			temp.add(cur.clone()); //cur안의 필드가 기본타입이거나 String 불변클래스라면 clone 안전 
		}
		return temp;
	}
	static class Fish implements Cloneable{
		int r;
		int c;
		int d;
		public Fish(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
		@Override
		protected Fish clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return (Fish) super.clone();
		}
		
		
	}
}
