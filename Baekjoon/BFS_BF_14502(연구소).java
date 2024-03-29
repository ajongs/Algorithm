import java.util.*;
import java.io.*;

class Main{
    static class Point{
      public int x;
      public int y;
      
      Point(int x, int y){
          this.x = x;
          this.y = y;
      }
      
      public int getX(){
          return this.x;
      }
      public int getY(){
          return this.y;
      }
    }
    static int maxSize=0;
    static int[][] copyMap;
    static int[][] map;
    static int n;
    static int m;
    static int[] dx ={0, 0, -1, 1};
    static int[] dy ={-1, 1, 0, 0};
    static ArrayList<Point> virus = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        m = Integer.parseInt(st[1]);
        
        map = new int[n][m];
        copyMap = new int[n][m];
        
        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(temp[j]);
                if(map[i][j] == 2){
                    virus.add(new Point(i,j));
                }
            }
        }
        setWall(0,0);
        System.out.println(maxSize);
    }
    static void setWall(int start, int wNum){
        if(wNum==3){
            initMap();
            //바이러스 퍼뜨리기
            spreadVirus();
            //0개수 확인
            maxSize = Math.max(maxSize, countNoneVirus());
            return;
        }
        for(int i=start; i<n*m; i++){
            int x = i/m;
            int y = i%m;
            
            if(map[x][y]==0){
                map[x][y]=1;
                setWall(i+1, wNum+1);
                map[x][y]=0;
            }
        }
    }
    static void initMap(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copyMap[i][j] = map[i][j];
            }
        }
    }
    static void spreadVirus(){
        Queue<Point> queue = new LinkedList<>();
        for(Point p : virus){
            queue.offer(p);
            
            while(!queue.isEmpty()){
                Point currentp = queue.poll();
                
                for(int i=0; i<4; i++){
                    int x = currentp.getX() + dx[i];
                    int y = currentp.getY() + dy[i];
                    if(x >=0 && x<n && y>=0 && y<m){
                      if(copyMap[x][y]==0){
                        copyMap[x][y]=2;
                        queue.offer(new Point(x,y));
                      }
                        
                    }
                }
            }
        }
    }
    static int countNoneVirus(){
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyMap[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}

/*
import java.io.*;
import java.util.*;

class Main{
    static int[][] map;
    static int[][] copyMap;
    static int safeAreaMaxSize=0;
    static int n;
    static int m;
    static List<Point> virus = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        map = new int[n][m];
        copyMap= new int[n][m];

        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(temp[j]);
                if(map[i][j]==2){
                    virus.add(new Point(i,j));
                }
            }
        }
        setWall(0,0);
        System.out.println(safeAreaMaxSize);

    }
    static void setWall(int start, int wallNum){
        if(wallNum == 3){
            //바이러스 뿌려보고
            spreadVirus();
            //0개수 파악 후
            int currentSize = getCount();
            //가장 많은 거로 치환
            safeAreaMaxSize = Math.max(safeAreaMaxSize, currentSize);
            return;
        }
        for(int i=start; i<n*m; i++){
            int x = i/m;
            int y = i%m;
            if(map[x][y] == 0){
                map[x][y] = 1;
                setWall(i+1, wallNum+1);
                map[x][y] =0;
            }
        }
    }
    static void spreadVirus(){
        //map 사본에 바이러스 뿌리기
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                copyMap[i][j] = map[i][j];
            }
        }
        Queue<Point> q = new LinkedList<>();
        for(Point p : virus){
            q.offer(p);

            int[] dx = {0,0,1,-1};
            int[] dy = {1,-1,0,0};
            while(!q.isEmpty()){
                Point curPoint = q.poll();

                for(int i=0; i<4; i++){
                    int x = curPoint.x + dx[i];
                    int y = curPoint.y + dy[i];
                    if(x>=0 && x<n && y>=0 && y<m){
                        if(copyMap[x][y]==0){
                            copyMap[x][y] = 2;
                            q.offer(new Point(x,y));
                        }
                    }
                }
            }
        }
    }
    static int getCount(){
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(copyMap[i][j] ==0){
                    count++;
                }
            }
        }
        return count;
    }
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x =x ;
            this.y = y;
        }
    }
}
*/

