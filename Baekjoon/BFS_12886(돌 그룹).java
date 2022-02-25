import java.io.*;
import java.util.*;

class Main{
    static boolean[][] check = new boolean[1501][1501];
    static int sum =0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int C = Integer.parseInt(str[2]);

        sum = A+B+C;
        if(sum%3 !=0){
            System.out.println(0);
            return;
        }
        bfs(A,B);
        if(check[sum/3][sum/3]){
            System.out.println(1);
        }
        else
            System.out.println(0);
    }
    static void bfs(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        while(!q.isEmpty()){
            Point cp = q.poll();
            int cx = cp.x;
            int cy = cp.y;
            if(check[cx][cy]==false){
                check[cx][cy] = true;
                int[] a = {cx, cy, sum-cx-cy};
                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){
                        if(a[i]<a[j]){
                            int[] b = {cx, cy, sum-cx-cy};
                            b[i] += a[i];
                            b[j] -= a[i];
                            q.offer(new Point(b[i],b[j]));
                        }
                    }
                }
            }
        }
    }
    static class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
