import java.io.*;

class Main{
    static int r;
    static int c;
    static int count=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        r = Integer.parseInt(str[1]);
        c = Integer.parseInt(str[2]);

        int size = (int)Math.pow(2,n);
        
        solve(0,0, size);
        System.out.println(count);
    }
    public static void solve(int x, int y, int size){
        if(size==2){
            for(int i=x; i<x+2; i++){
                for(int j=y; j<y+2; j++){
                    if(i==r && j==c)
                        return;
                    count++;
                }
            }

        }
        //사이즈 나누가 2 한게 어디에 속하는지 일단 체크
        int half = size / 2;
        //2사분면
        if(x<=r && r< x+half && y<=c && c < y+half){
            solve(x, y, half);
        }
        //1사분면
        else if(x<=r && r< x+half && y+half<=c && c < y+size){
            count += half*half;
            solve(x, y+half, half);
        }
        else if(x+half <=r && r<x+size && y<=c && c< y+half){
            count += 2*half*half;
            solve(x+half, y, half);
        }
        else{
            count += 3*half*half;
            solve(x+half, y+half, half);
        }
        //그다음 속한 곳의 앞의 영역들 카운트에 추가
    }
}
