import java.util.*;
import java.io.*;


public class Main
{
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int count=0;
    static boolean[][] visited;
    static int n;
    static int answer = Integer.MIN_VALUE;
    static int[] pos = new int[4];
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int[][] arr = new int[3 * n][n];
        for (int i = 0; i < 3 * n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        
        recursion(3, arr, 0);
        System.out.println(answer);
    }
    public static void dropDown(int[][] arr) {
        for (int j = pos[3]; j <= pos[2]; j++) {
            for (int i = pos[0]; i >= pos[1]; i--) {
                if (arr[i][j] != 0) continue;
                int blank = 0;

                for (int k = i-1; k >= 0; k--) {
                    if (arr[k][j] != 0) {
                        blank = i - k;
                        break;
                    }
                }

                if (blank > 0) {
                    for (int k = i; k >= blank; k--) {
                        arr[k][j] = arr[k - blank][j];
                        arr[k - blank][j] = 0;
                    }
                }
                
            }
        }
    }
    public static void recursion(int depth, int[][] arr, int result) {
        if (depth == 0) {
            answer = Math.max(answer, result);
            return;
        }
        int[][] copy = copyArr(arr);
        boolean[][] visited = new boolean[3 * n][n];
        for (int i = 3 * n - n; i < 3 * n; i++) {
            for (int j = 0 ; j < n; j++) {
                if (visited[i][j]) continue;    
                int score = bfs(i, j, arr[i][j], arr, visited);
                if (depth > 1) {
                    dropDown(arr);
                    recursion(depth - 1 , arr, result + score);
                    arr = copyArr(copy);
                }
                else
                    recursion(depth - 1 , arr, result + score);
                
            }
        }
    }
    public static void print(int[][] arr) {
        for (int i=0 ; i<3*n; i++) {
            for (int j = 0; j<n; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int bfs(int sr, int sc, int color, int[][] arr, boolean[][] visited) {
        
        visited[sr][sc] = true;
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] {sr, sc});
        arr[sr][sc] = 0;

        
        pos[0] = sr;
        pos[1] = sr;
        pos[2] = sc;
        pos[3] = sc;

        int count = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if (rangeOver(nr, nc) || arr[nr][nc] == 0 || arr[nr][nc] != color) continue;
                arr[nr][nc] = 0;
                visited[nr][nc] = true;
                pos[0] = Math.max(pos[0], nr);
                pos[1] = Math.min(pos[1], nr);
                pos[2] = Math.max(pos[2], nc);
                pos[3] = Math.min(pos[3], nc);
                
                q.offer(new int[] {nr, nc});
            }
        }
        return getScore(count, pos);
    }
    public static int getScore(int count, int[] pos) {
        int bottom = pos[0];
        int top = pos[1];
        int right = pos[2];
        int left = pos[3];

        return (bottom - top + 1) * (right - left + 1) + count;
    }
    public static boolean sameNumberInRange(int sr, int sc, int[][] arr) {
        for (int i = 0; i < 4; i++) {
            int nr = sr + dr[i];
            int nc = sc + dc[i];

            if(rangeOver(nr, nc) || arr[sr][sc] != arr[nr][nc]) continue;
            return true; //최소 하나가 같으니까 지울 수 있음 
        }
        return false;
    }
    public static int[][] copyArr(int[][] arr) {
        int[][] copy = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }
    public static boolean rangeOver(int nr, int nc) {
        if (nr < 3 * n - n || nr >= 3 * n || nc < 0 || nc >= n) {
            return true;
        }
        return false;
    }
}
