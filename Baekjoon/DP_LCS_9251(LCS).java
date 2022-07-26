import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int n = Math.max(str1.length(), str2.length());
        int[][] d = new int[n+1][n+1];

        for(int i=0; i<=str1.length(); i++){
            for(int j=0; j<=str2.length(); j++){
                if(i==0 || j==0){
                    d[i][j] =0;
                    continue;
                }
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    d[i][j] = d[i-1][j-1] + 1;
                }
                else
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
            }
        }

        int max = 0;
        for (int[] ints : d) {
            for (int anInt : ints) {
                max = Math.max(max, anInt);
            }
        }
        System.out.println(max);
    }
}
