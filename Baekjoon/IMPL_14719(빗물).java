import java.io.*;

class Main{
    static String[] words;
    static boolean[] alphabet = new boolean[26];
    static int max = -1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int H = Integer.parseInt(str[0]);
        int W = Integer.parseInt(str[1]);
        int[] map = new int[W];

        str = br.readLine().split(" ");
        for(int i=0; i<W; i++){
            map[i] = Integer.parseInt(str[i]);
        }

        int result=0;
        for(int i=1; i<W-1; i++){
            int left=0;
            int right=0;

            for(int j=i-1; j>=0; j--){
                left = Math.max(left, map[j]);
            }

            for(int j=i+1; j<W; j++){
                right = Math.max(right, map[j]);
            }

            if(left > map[i] && right > map[i])
                result += Math.min(left, right) - map[i];
        }
        System.out.println(result);
    }
}
