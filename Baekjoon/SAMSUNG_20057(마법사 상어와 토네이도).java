import java.io.*;

public class Main {

	static int n;
	static int[][] map;
	static int[] dr = {0,1,0,-1};
	static int[] dc = {-1,0,1,0};
	static int[][] ratioR = {{-1,1,-1,1,-2,2,-1,1,0}, {-1,-1,0,0,0,0,1,1,2},
			{-1,1,-1,1,-2,2,-1,1,0}, {1,1,0,0,0,0,-1,-1,-2}};
	static int[][] ratioC = {{1,1,0,0,0,0,-1,-1,-2},{-1,1,-1,1,-2,2,-1,1,0},
			{-1,-1,0,0,0,0,1,1,2}, {-1,1,-1,1,-2,2,-1,1,0}};
	static int[] ratioNum = {1,1,7,7,2,2,10,10,5};
	static int answer =0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		
		int sr = n/2;
		int sc = n/2;
		
		int count=0;
		int searchCnt=1;
		int d=0;
		int idx=1;
		while(true) {
			if(count==2) {
				count=0;
				searchCnt++;
			}
			for(int i=0; i<searchCnt; i++) {
				sr += dr[d];
				sc += dc[d];
				if(sr<0 || sr>=n || sc <0 || sc >=n) break;
				blow(sr,sc,d);
				
			}
			if(sr<0 || sr>=n || sc <0 || sc >=n) break;
			d = (d+1)%4;
			count++;
		}
		
		System.out.println(answer);
		
	}
	
	static void blow(int r, int c, int d) {
		
		int y = map[r][c]; //처음 모래 양
		int total = y;
		for(int i=0; i<9; i++) {
			int nr = r + ratioR[d][i];
			int nc = c + ratioC[d][i];
			 
			int amount = y * ratioNum[i] /100 ;
			if(nr <0 || nr>=n || nc <0 || nc >=n) { //범위를 넘어가면 카운트해주기
				answer += amount;
			}
			else {
				map[nr][nc] += amount ;
				
			}
			total -= amount;
		}
		
		int ar = r+dr[d];
		int ac = c+dc[d];
		if(ar <0 || ar>=n || ac <0 || ac >=n) {
			answer += total;
		}
		else
			map[ar][ac] += total; //a 에 나머지 쌓아주기
		
		map[r][c] = 0;
		
	}
}
