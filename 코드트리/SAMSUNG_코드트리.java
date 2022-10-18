package SAMSUNG;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class codeTree_2022_second_02 {
    static int[] dr = {-1,0,0,1};
    static int[] dc = {0,-1,1,0};
    static int n;
    static int m;
    static int[][] map;
    static int[][] convenient;
    static boolean[][] visited;
    static ArrayList<Pos> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        map = new int[n][n];
        convenient= new int[m][2];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                if(str[j].equals("0")) continue;
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        for(int i=0; i<m; i++){
            str = br.readLine().split(" ");
            int r = Integer.parseInt(str[0])-1;
            int c = Integer.parseInt(str[1])-1;
            convenient[i][0] = r;
            convenient[i][1] = c;
        }


        int answer=1;
        while(true){
            for(int j=0; j<list.size(); j++){
                go(list.get(j), j);
            }
            if(answer-1 < m){
                Pos start = decideStartPos(convenient[answer-1][0],convenient[answer-1][1]);
                list.add(start);
            }

            if(isFinish()) break;
            answer++;
        }
        System.out.println(answer);
    }
    public static void m(Pos cur){
        cur.r +=100;
        cur.c +=100;
    }
    public static boolean isFinish(){
        if(list.size() < m) return false; //처음 시작해야함
        int idx=0;
        for(Pos cur : list){
            if(!(cur.r == convenient[idx][0] && cur.c == convenient[idx++][1])){
                return false;
            }
        }
        return true;
    }
    public static void go(Pos start, int num){
        //이미 도착한 경우는 돌지 않음
        if(start.r == convenient[num][0] && start.c == convenient[num][1]) return;

        boolean[][] tempVisited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start.r, start.c, 0});
        tempVisited[start.r][start.c] = true;

        int idx=0;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(cur[0] == convenient[num][0] && cur[1] == convenient[num][1]){
                start.r = start.r + dr[cur[2]];
                start.c = start.c + dc[cur[2]];
                return;
            }

            for(int i=0; i<4; i++){
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                int d=cur[2];
                if(nr<0 || nr>=n || nc<0 ||nc>=n || visited[nr][nc]) continue;
                if(tempVisited[nr][nc]) continue;
                tempVisited[nr][nc] = true;
                if(idx==0){
                    d = i;
                }
                q.offer(new int[]{nr,nc,d});
            }
            idx++;
        }

    }
    public static Pos decideStartPos(int r, int c){
        boolean[][] tempVisited = new boolean[n][n];
        Queue<Pos> q = new LinkedList<>();
        q.offer(new Pos(r,c));
        tempVisited[r][c] = true;

        while(!q.isEmpty()){
            Pos cur = q.poll();

            if(map[cur.r][cur.c] == 1){
                visited[cur.r][cur.c] = true;
                return cur;
            }

            for(int i=0; i<4; i++){
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if(nr<0 || nr>=n || nc<0 ||nc>=n || visited[nr][nc]) continue;
                if(tempVisited[nr][nc]) continue;
                tempVisited[nr][nc] = true;
                q.offer(new Pos(nr,nc));
            }
        }
        return null;
    }
    static class Pos{
        int r;
        int c;
        Pos(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    static class People{
        int r;
        int c;
        boolean visitedStore;
        People(int r, int c){
            this.r=r;
            this.c=c;
            visitedStore=false;
        }
    }
}
