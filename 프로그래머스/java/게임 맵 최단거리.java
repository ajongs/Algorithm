import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        return bfs(0,0, maps);
    }
    public int bfs(int sr, int sc, int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sr, sc});
        maps[sr][sc] = 0;
        int answer = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            answer++;
            while (size-- > 0) {
                int[] cur = q.poll();
                if (cur[0] == n - 1 && cur[1] == m - 1) return answer;
                
                for (int i=0; i<4; i++) {
                    int nr = cur[0] + dr[i];
                    int nc = cur[1] + dc[i];
                    
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || maps[nr][nc] == 0) continue;
                    maps[nr][nc] = 0;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
        return -1;
    }
}
