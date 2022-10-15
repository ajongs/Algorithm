import java.io.*;

public class Main {
	static int n;
	static int q;
	static int length;
	static int[][] A;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int answer=0;
	static int max = Integer.MIN_VALUE;
	static int dfsCnt=0;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		q = Integer.parseInt(str[1]);
		length = (int)Math.pow(2, n);
		A = new int[length+1][length+1];
		
		for(int i=1; i<=length; i++) {
			str = br.readLine().split(" ");
			for(int j=1; j<=length; j++) {
				A[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		str = br.readLine().split(" ");
		for(int i=0; i<q; i++) {
			int L = Integer.parseInt(str[i]);
			
			divide(L);
			subtraction();
		}
		visited = new boolean[length+1][length+1];
		for(int i=1; i<=length; i++) {
			for(int j=1; j<=length; j++) {
				answer += A[i][j];
				if(A[i][j]!=0 && !visited[i][j]) {
					dfsCnt =0;
					dfs(i,j);
					max = Math.max(max, dfsCnt);
				}
			}
		}
		System.out.println(answer);
        if(max == Integer.MIN_VALUE) {
			System.out.println(0);
			return;
		}
		System.out.println(max);
		/*
		for(int i=1; i<=length; i++) {
			for(int j=1; j<=length; j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}*/
	}
	public static void dfs(int r, int c) {
		visited[r][c] = true;
		dfsCnt++;
		for(int i=0; i<4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if(nr<1 || nr>length || nc<1 || nc>length || visited[nr][nc]) continue;
			if(A[nr][nc] ==0) continue;
			dfs(nr,nc);
		}
	}
	public static void subtraction() {
		int[][] minus = new int[length+1][length+1];
		for(int i=1; i<length+1; i++) {
			for(int j=1; j<length+1; j++) {
				int adjCnt=0;
				if(A[i][j]==0) continue;
				for(int d=0; d<4; d++) {
					int nr = i+dr[d];
					int nc = j+dc[d];
					
					if(nr<1 || nr>length || nc<1 || nc>length) continue;
					if(A[nr][nc] ==0) continue;
					adjCnt++;
				}
				if(adjCnt<3)
					minus[i][j]++;
			}
		}
		
		for(int i=1; i<length+1; i++) {
			for(int j=1; j<length+1; j++) {
				A[i][j] -= minus[i][j];
			}
		}
		
	}
	public static void divide(int L) {
		int[][] temp = new int[length+1][length+1];
		int sr=1;
		int sc=1;
		int size = (int)Math.pow(2,L);
		//a[0,0] b[0,1]
		//a[0,1] b[1,1]
		//a[1,0] b[0,0]
		//a[1,1] b[1,0]
		
		//a[1,3] b[1,4]  a[1,1] b[1,4]
		//a[1,4] b[2,4]  a[1,2] b[2,4]
		//a[2,3] b[1,3]  a[1,3] b[3,4]
		//a[2,4] b[2,3]  a[1,4] b[4,4]
		
		//a[1,5] b[1,8]
		//a[1,6] b[2,8]
		//a[1,7] b[3,8]
		//a[1,8] b[4,8]
		int roop = (length*length)/(size*size);
		
		for(int r=0; r<roop; r++) {
			for(int i=0; i<size; i++) {
				for(int j=0;j <size; j++) {
					temp[sr+j][sc+size-1-i] = A[sr+i][sc+j];
				}
			}
			sc += size;

			if(sc > length) {
				sr += size;
				sc = 1;
			}
		}
		A = temp;
		
	}

}
