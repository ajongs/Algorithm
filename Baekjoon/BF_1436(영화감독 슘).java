
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count=0;
        String str = "666";
        for(int i=1 ;count != n ; i++){
            if(Integer.toString(i).contains("666")){
                count++;
            }
            if(count == n){
                System.out.println(i);
            }
        }
    }

}
