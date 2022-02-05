import java.io.*;

class Main{
    static int[] arr;
    static int d;
    static long tx, ty;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str1 = br.readLine().split(" ");
        String[] str2 = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        d = Integer.parseInt(str1[0]);
        arr = new int[d];
        for(int i=0; i<d; i++){
            arr[i] = str1[1].charAt(i)-'0';
        }

        long moveX = Long.parseLong(str2[0]);
        long moveY = Long.parseLong(str2[1]);

        long size = (long) Math.pow(2, d);
        findLocation(0,0,0, size);

        tx -= moveY;
        ty += moveX;
        long x=0, y=0;
        if(0<=tx && tx<size && 0<= ty && ty<size){
            for(int i=0; i<d; i++){
                //1사분면
                if(x <= tx && tx<x+size/2 && y+size/2 <= ty && ty < y+size){
                    sb.append("1");
                    y=y+size/2;
                }
                //2사분면
                else if(x <= tx && tx<x+size/2 && y <= ty && ty < y+size/2){
                    sb.append("2");
                }
                //3사분면
                else if(x+size/2 <= tx && tx<x+size && y <= ty && ty < y+size/2){
                    sb.append("3");
                    x = x+size/2;
                }
                else if(x+size/2 <= tx && tx<x+size && y+size/2 <= ty && ty < y+size){
                    sb.append("4");
                    x = x+size/2;
                    y = y+size/2;
                }
                size/= 2;
            }
        }
        else
            bw.write("-1");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    public static void findLocation(int index, long x, long y, long size){
        if(index == d){
            tx= x;
            ty= y;
            return;
        }
        if(arr[index]==1){
            findLocation(index+1, x, y+size/2, size/2);
        }else if(arr[index]==2){
            findLocation(index+1, x,y,size/2);
        }else if(arr[index]==3){
            findLocation(index+1, x+size/2, y, size/2);
        }else{
            findLocation(index+1, x+size/2, y+size/2, size/2);
        }
    }
}
