import java.io.*;

class Main{
    static int[][] array;
    static int[] cnt = new int[3]; // index 0 : -1의 개수
                                   // index 1 : 0의 개수
                                   // index 2 : 1의 개수
    public static void main(String[] args ) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        
        array = new int[n][n];
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(str[j]); 
            }
        }
        solve(0,0,n);
        for(int a : cnt){
            System.out.println(a);
        }
    }
    public static void solve(int x, int y, int n){
        if(same(x, y, n)){
            cnt[array[x][y]+1] += 1;
            return;
        }
        int divN = n/3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                solve(x+i*divN, y+j*divN, divN);
            }
        }
    }
    public static boolean same(int x, int y, int n){
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(array[x][y]!=array[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
