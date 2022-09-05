import java.io.*;
import java.util.*;
class Main {
    static char[][] map;
    static int answer=0;
    static int[] dr = {-1,1,0,0}; //위, 아래, 좌, 우
    static int[] dc = {0,0,-1,1};
    static boolean visited[][][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        map = new char[n][m];
        visited = new boolean[n][m][n][m];
        int redR=0;
        int redC =0;
        int blR =0;
        int blC=0;
        for(int i=0; i<n; i++){
            String temp = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = temp.charAt(j);
                if(map[i][j]=='R'){
                    redR = i;
                    redC = j;
                }
                else if(map[i][j] == 'B'){
                    blR = i;
                    blC = j;
                }
            }
        }
        System.out.println(bfs(redR, redC, blR, blC,1));
    }
    public static int bfs(int redR, int redC, int blR, int blC, int cnt){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{redR,redC,blR,blC,cnt});
        visited[redR][redC][blR][blC] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curCnt = cur[4];

            if(curCnt>10) return -1;


            for(int i=0; i<4; i++){
                //위 아래 좌 우
                boolean redFirst;
                boolean redOut = false;
                boolean blueOut = false;
                int rR = cur[0];
                int rC = cur[1];
                int bR = cur[2];
                int bC = cur[3];

                if(i==0){
                    if(rR > bR) redFirst = false;
                    else redFirst = true;
                }else if(i==1){
                    if(rR < bR){
                        redFirst = false;
                    }
                    else {
                        redFirst = true;
                    }
                }else if(i==2){
                    if(rC > bC){
                        redFirst = false;
                    }
                    else{
                        redFirst = true;

                    }
                }else{
                    if(rC < bC){
                        redFirst = false;
                    }
                    else{
                        redFirst = true;
                    }
                }
                while(map[rR+dr[i]][rC+dc[i]] != '#'){
                    rR += dr[i];
                    rC += dc[i];

                    if(map[rR][rC] == 'O'){
                        redOut = true;
                        break;
                    }
                }
                while(map[bR + dr[i]][bC + dc[i]] != '#'){
                    bR += dr[i];
                    bC += dc[i];

                    if(map[bR][bC] == 'O'){
                        blueOut = true;
                        break;
                    }
                }

                if(blueOut){
                    continue;
                }
                if(redOut && !blueOut){
                    return curCnt;

                }

                if(rR == bR && rC == bC){
                    if(i==0 || i==1){
                        if(redFirst){
                            bR -= dr[i];
                        }
                        else{
                            rR -= dr[i];
                        }
                    }else if(i==2 || i==3){
                        if(redFirst) bC -= dc[i];
                        else rC -= dc[i];
                    }
                }

                if(!visited[rR][rC][bR][bC]){
                    visited[rR][rC][bR][bC] = true;
                    q.offer(new int[]{rR,rC,bR,bC,curCnt+1});
                }

            }
            //어떤 것 부터 움직여야할지 생각하자
            //왼쪽으로 기우는 경우 더 C가 더 작은 것이 먼저 움직여야함

            //오른쪽으로 기우는 경우 C가 더 큰게 먼저 움직

            //위쪽은 R이 더 작은게 먼저

            //아래쪽은 R이 더 큰거 먼저
        }
        return -1;
    }
}
