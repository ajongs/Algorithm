import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int g = Integer.parseInt(br.readLine());

        boolean flag=true;
        int now=1;
        int before=1;
        while(before <= now && before<=100000){
            int result = now*now - before*before;
            if(result < g){
                now++;
            }
            else if(result == g){
                bw.write(now+"\n");
                flag = false;
                now++;
                before++;
            }else{
                before++;
            }
        }
        if(flag){
            System.out.println(-1);
            return;
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
