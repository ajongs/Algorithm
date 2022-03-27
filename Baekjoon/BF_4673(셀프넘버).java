import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException {
        boolean[] noSelfNum = new boolean[10001];
        for(int i=1; i<10001; i++){
            int sum=0;
            int num=i;
            while(num!=0){
                sum += num % 10;
                num/=10;
            }
            if(sum+i<10001 && sum+i>i){
                noSelfNum[sum+i] = true;
            }
        }

        for(int i=1; i<10001; i++){
            if(!noSelfNum[i])
                System.out.println(i);
        }

    }
}
