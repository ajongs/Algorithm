import java.io.*;
import java.util.Scanner;
public class Main{
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            int item = n%b;
            if(item >= 10){
                sb.append((char)(item-10+'A'));
            }
            else{
                sb.append(item);
            }
            n /= b;
        }
        sb.reverse();
        System.out.println(sb.toString());
    }
}
