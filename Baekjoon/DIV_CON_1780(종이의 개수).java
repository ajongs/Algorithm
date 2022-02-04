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

/* review code
import java.io.*;

class Main{
    static int[][] array;
    static int[] cnt=new int[3]; //-1, 0 ,1 각각 1더한게 인덱스 자리
    public static void main(String[] args) throws IOException{
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
        for(int c : cnt){
            System.out.println(c);
        }
    }
    public static void solve(int x, int y, int length){
        if(isSame(x,y,length)){
            cnt[array[x][y]+1] += 1;
            return;
        }
        int div = length /3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                solve(x+div*i, y+div*j, div);
            }
        }
    }
    public static boolean isSame(int x, int y, int length){
        for(int i=x; i<x+length; i++){ // i<x+length 조심하자 0,0이 아닐때도 생각해야지
            for(int j=y; j<y+length; j++){
                if(array[x][y] != array[i][j])
                    return false;
            }
        }
        return true;
    }
}*/
