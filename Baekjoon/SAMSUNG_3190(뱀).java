import java.io.*;
import java.util.*;
class Main {
    static int[][] map;
    static int[] dr = {0, 1, 0, -1}; //오 아 왼 위 순서
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        map = new int[n+1][n+1];
        for(int i=0; i<k; i++) {
            String[] str = br.readLine().split(" ");
            int row = Integer.parseInt(str[0]);
            int col = Integer.parseInt(str[1]);
            map[row][col] = 1;
        }
        int L = Integer.parseInt(br.readLine());
        Queue<Direction> q = new LinkedList<>();
        for(int i=0; i<L; i++) {
            String[] str = br.readLine().split(" ");
            q.offer(new Direction(Integer.parseInt(str[0]), str[1]));
        }
        int r=1;
        int c=1;
        int dir=0;
        int time=0;
        Queue<Position> body = new LinkedList<>();
        body.offer(new Position(1,1));
        while(true) {
            time++;
            r = r + dr[dir];
            c = c + dc[dir];

            if(r <1 || r > n || c <1 || c > n || map[r][c]==2) {
                break;
            }

            if(map[r][c] != 1){
                Position rear = body.poll();
                map[rear.r][rear.c] = 0;
            }
            body.offer(new Position(r,c));
            map[r][c] = 2;

            if(q.size()>0 && q.peek().sec == time) {
                //방향 바꿔 줘야함
                Direction cur = q.poll();
                if (cur.isRight) {
                    //오른쪽 일때
                    dir = (dir + 1) % 4;
                } else { //왼쪽일때
                    dir = (dir + 3) % 4;
                }

            }
        }

        System.out.println(time);
    }
}
class Direction{
    int sec;
    boolean isRight;

    public Direction(int sec, String s) {
        this.sec = sec;

        if(s.equals("D")) isRight = true;
        else isRight = false;
    }
}
class Position{
    int r;
    int c;
    public Position(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
