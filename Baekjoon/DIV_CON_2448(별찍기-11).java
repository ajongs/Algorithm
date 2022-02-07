import java.io.*;

class Main{
    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new char[n][2*n-1];
        for(int i=0; i<n; i++){
            for(int j=0; j<2*n-1; j++){
                arr[i][j] = ' ';
            }
        }
        star(n-1, 0, n);
        for(int i=0; i<n; i++){
            bw.write(arr[i]);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void star(int row, int column, int size){
        if(size==3){
            arr[row][column]=arr[row][column+1]=arr[row][column+2]=arr[row][column+3]=arr[row][column+4]='*';
            arr[row-1][column+1]=arr[row-1][column+3]='*';
            arr[row-2][column+2]='*';
            return;
        }
        int div = size/2;
        star(row,column,div);
        star(row-div, column+div, div);
        star(row, column+div*2, div);
    }
}
