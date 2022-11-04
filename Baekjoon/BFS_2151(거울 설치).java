import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class bj_2151 {
    static char[][] map;
    static int n;
    static List<Pos> list = new ArrayList<>();
    static int[] dr = {1,0,-1,0}; //하 좌 상 우
    static int[] dc = {0,-1,0,1};

    static int sr, sc;
    static boolean[][][] visited;
    static class Pos implements Comparable<Pos>{
        int r;
        int c;
        int mirror;
        int d;

        public Pos(int r, int c, int mirror, int d){
            this.r =r ;
            this.c =c ;
            this.mirror = mirror;
            this.d =d;
        }
        @Override
        public int compareTo(Pos o1){
            return this.mirror - o1.mirror; //작은 순
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        String str;
        map = new char[n][n];

        for(int i=0; i<n; i++){
            str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j);
                if (map[i][j] == '#'){
                    sr = i;
                    sc = j;
                }
            }
        }
        visited = new boolean[n][n][4];
        bfs();
    }
    public static void bfs(){
        Queue<Pos> pq = new PriorityQueue<>();
        int answer=Integer.MAX_VALUE;
        for(int i=0; i<4; i++){
            pq.offer(new Pos(sr,sc,0, i));
            visited[sr][sc][i] = true;
            while(!pq.isEmpty()){
                Pos cur = pq.poll();


                if(map[cur.r][cur.c] == '#' && !(cur.r==sr && cur.c == sc)){
                    answer = Math.min(answer, cur.mirror);
                    break;
                }

                int nr = cur.r + dr[cur.d];
                int nc = cur.c + dc[cur.d];

                if(nr < 0 || nr >=n || nc <0 || nc >= n || map[nr][nc] == '*') continue;
                if(map[nr][nc] == '!'){
                    int nd;
                    //방향 배열 기준 오른쪽 선택
                    nd = (cur.d + 1) % 4;
                    if(!visited[nr][nc][nd]){
                        visited[nr][nc][nd] = true;
                        pq.offer(new Pos(nr,nc,cur.mirror + 1, nd));
                    }
                    //방향 배열 기준 왼쪽 선택
                    nd = (cur.d + 3) % 4;
                    if(!visited[nr][nc][nd]){
                        visited[nr][nc][nd] = true;
                        pq.offer(new Pos(nr,nc,cur.mirror + 1, nd));
                    }


                }
                //혹은 거울 설치 x
                if(!visited[nr][nc][cur.d]){
                    visited[nr][nc][cur.d] = true;
                    pq.offer(new Pos(nr,nc,cur.mirror, cur.d));
                }

            }
        }
        System.out.println(answer);
    }


}
