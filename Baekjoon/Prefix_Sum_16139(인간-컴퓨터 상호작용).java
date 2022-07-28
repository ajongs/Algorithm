import java.io.*;

class Main{
    static String str;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        arr = new int[26][str.length()];
        arr[str.charAt(0)-'a'][0]++;
        for(int i=1; i<str.length(); i++){
            int alpa = str.charAt(i)-'a';
            for(int j=0; j<26;j++){
                arr[j][i] = arr[j][i-1];
            }
            arr[alpa][i]++;
        }
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        //System.out.println < BufferedWriter < StringBuilder --> 가장 빠름
        
        for(int i=0; i<n; i++){
            String[] query = br.readLine().split(" ");
            int a = query[0].charAt(0)-'a';
            int start = Integer.parseInt(query[1]);
            int end = Integer.parseInt(query[2]);

            if(start ==0){
                sb.append(arr[a][end]).append('\n');
            }
            else
                sb.append(arr[a][end] - arr[a][start-1]).append('\n');

        }
        System.out.println(sb);
    }
}
