import java.util.Scanner;

class Main{
    static int k=0;//옮긴 횟수
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        solve(n, 1, 3);
        System.out.println(k);
        System.out.print(sb);
    }
    public static void solve(int n, int x, int y){
        if(n==0) return;
        solve(n-1, x, 6-x-y);
        sb.append(x+" "+y+"\n");
        k++;
        solve(n-1, 6-x-y, y);
    }
}
