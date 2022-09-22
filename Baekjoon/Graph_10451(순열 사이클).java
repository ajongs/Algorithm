import java.io.*;

class Main{
    static boolean[] visited;
    static int answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            visited = new boolean[n+1];
            answer =0;
            String[] str = br.readLine().split(" ");
            int[] arr = new int[n+1];
            
            for(int j=0; j<str.length; j++){
                arr[j+1] = Integer.parseInt(str[j]);
            }
            for(int k=1; k<arr.length; k++){
                if(visited[k]) continue;
                goNext(k, arr);
            }
            System.out.println(answer);
        }
    }
    public static void goNext(int i, int[] arr){
        if(visited[i]) {
            answer++;  
            return;
        }
        visited[i] = true;
        goNext(arr[i], arr);
    }
}
