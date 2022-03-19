import java.util.*;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];
        int[] dx= {-1, 1, 0 ,0};
        int[] dy= {0, 0, -1, 1};
        Queue<Point> q = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j] || picture[i][j]==0) continue;
                int count=1;
                q.offer(new Point(i,j, picture[i][j]));
                visited[i][j] = true;
                
                while(!q.isEmpty()){
                    Point cp = q.poll();

                    for(int k=0; k<4; k++){
                        int nx = cp.x + dx[k];
                        int ny = cp.y + dy[k];
                        if(nx>=0 && nx<m && ny>=0 && ny<n){
                            if(!visited[nx][ny] && cp.color == picture[nx][ny]
                              && picture[nx][ny] != 0){
                                visited[nx][ny] = true;
                                q.offer(new Point(nx, ny, picture[nx][ny]));
                                count++;
                            }
                        }
                    }
                }
                maxSizeOfOneArea = Math.max(count, maxSizeOfOneArea);
                numberOfArea++;
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    static class Point{
        int x;
        int y;
        int color;
        Point(int x, int y, int color ){
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }
}
