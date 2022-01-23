import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0) System.out.println(n);
        StringBuilder sb = new StringBuilder();
        while(n!=0){
            sb.append(Math.abs(n%-2));
            n = (int)Math.ceil((double)n/-2);
        }
        System.out.println(sb.reverse());
    }
}
