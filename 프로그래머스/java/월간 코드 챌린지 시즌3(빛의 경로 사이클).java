import java.util.*;

class Solution {
    int[] dr = {0,1,0,-1};
    int[] dc = {1,0,-1,0};
    int n;
    int m;
    boolean[][][] visited;
    List<Integer> ansList = new ArrayList<>();
    public int[] solution(String[] grid) {
        n = grid.length;
        m = grid[0].length();
       
        visited = new boolean[n][m][4];
        for(int r=0; r<n; r++){
            for(int c =0; c<m; c++){
                for(int i=0; i<4; i++){
                    if(visited[r][c][i]) continue;
                    ansList.add(search(r,c,i,grid));
                }
            }
        }
        
        
        int[] answer = ansList.stream().sorted().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    public int search(int r, int c, int dir, String[] grid){
        int count=0;
        
        while(true){
            if(visited[r][c][dir])
                break;
            
            visited[r][c][dir] = true;
            count++;
            
            if(grid[r].charAt(c) == 'R'){
                dir = (dir+1)%4;
            }else if(grid[r].charAt(c) == 'L'){
                dir = (dir-1+4) % 4;
            }
            r = (n+ r + dr[dir])%n;
            c = (m+ c + dc[dir])%m;
        }
        return count;
    }
    
}
