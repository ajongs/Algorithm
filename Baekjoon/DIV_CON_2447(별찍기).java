import java.io.*;

class Main{
    static char[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        star(0, 0, n, false);

        for(int i=0; i<n; i++){
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
    public static void star(int x, int y, int size, boolean blank){
        if(blank){
            for(int i=x; i<x+size; i++){
                for(int j=y; j<y+size; j++){
                    arr[i][j] = ' ';
                }
            }
            return;
        }
        if(size==1){
            arr[x][y] = '*';
            return;
        }

        int div = size/3;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                //공백칸일 경우
                if(i==1 && j==1){
                    star(x+i*div, y+j*div, div, true);
                }
                else
                    star(x+i*div, y+j*div, div, false);
            }
        }
    }

}
