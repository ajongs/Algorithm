import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Main {
    static int[][] map;
    static List<int[]> cctv = new ArrayList<>();
    static int[] dr = {1,0, -1,0}; //상 우 하 좌
    static int[] dc = {0,1, 0,-1};
    static int n;
    static int m;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][m];

        for(int i=0; i<n; i++){
            str = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(str[j]);
                if(map[i][j] !=0 && map[i][j] != 6){
                    cctv.add(new int[]{i,j});
                }
            }
        }
        //모든 경우의 수를 고려해서
        dfs(0);
        //0의 개수가 가장 적은 경우
        System.out.println(answer);

    }
    public static void dfs(int depth){
        if(depth >= cctv.size()) {
            //개수 계산하고 리턴
            int result = count();
            answer = Math.min(answer, result);
            return;
        }
        //자기가 감시할 수 있는 모든경우 탐색
        int[] cur = cctv.get(depth);
        int r = cur[0];
        int c = cur[1];

        int[][] copyMap = new int[n][m];
        copy(map, copyMap);
        //cur 종류가 뭔지 중요함
        int num = map[r][c];
        if(num ==1){
            for(int i=0; i<4; i++){
                //방향을 일단 파악해야되고
                //그 방향으로 끝까지 탐색해보고
                search(r, c, i);
                //0개수 저장? 파라미터로 주든 뭐 어캐하고
                //그 다음 cctv dfs
                dfs(depth+1);
                copy(copyMap, map);
            }
        }
        else if(num==2){
            //두번만하면됨
            for(int i=0; i<2; i++){
                search(r, c, i);
                int dir = (i+2) %4;
                search(r,c,dir);
                dfs(depth+1);
                copy(copyMap, map);
            }
        }else if(num==3){
            for(int i=0; i<4; i++){
                search(r,c,i);
                int dir = (i+1) %4;
                search(r,c,dir);
                dfs(depth+1);
                copy(copyMap, map);
            }
        }else if(num==4){
            for(int i=0; i<4; i++){
                search(r,c,i);
                int dir_1 = (i+1) %4;
                int dir_2 = (i+2) %4;
                search(r,c,dir_1);
                search(r,c,dir_2);
                dfs(depth+1);
                copy(copyMap, map);
            }
        }else{ //
            search(r,c,0);
            search(r,c,1);
            search(r,c,2);
            search(r,c,3);
            dfs(depth+1);
        }


    }
    public static void search(int nextR, int nextC, int dir){
        nextR += dr[dir];
        nextC += dc[dir];
        while(nextR < n && nextC < m && nextR >=0 && nextC >= 0){
            if(map[nextR][nextC] == 6) break;
            else if(map[nextR][nextC] !=0) {
                nextR += dr[dir];
                nextC += dc[dir];
                continue;
            }
            map[nextR][nextC] = 7;
            nextR += dr[dir];
            nextC += dc[dir];
        }
    }
    public static void copy(int[][] map, int[][] copy){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copy[i][j] = map[i][j];
            }
        }
    }
    public static int count(){
        int result=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j] == 0) result++;
            }
        }
        return result;
    }
}
