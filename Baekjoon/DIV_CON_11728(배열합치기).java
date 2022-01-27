import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] a = new int[n];
        int[] b = new int[m];
        String[] str2 = br.readLine().split(" ");
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(str2[i]);
        }

        String[] str3 = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            b[i] = Integer.parseInt(str3[i]);
        }

        int i=0;
        int j=0;
        int[] ans=new int[n+m];
        int k=0;
        while(i<=n-1 && j<=m-1){
            if(a[i]<b[j]){
                ans[k++] = a[i++];
            }
            else
                ans[k++] = b[j++];
        }
        while(i<=n-1) ans[k++] = a[i++];
        while(j<=m-1) ans[k++] = b[j++];

        for(int t : ans){
            bw.append(t+" ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
