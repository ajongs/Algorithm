import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] count = new int[2];

        //첫번째 값 넣어주기
        count[str.charAt(0)-'0']++;

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i-1) != str.charAt(i)){
                count[str.charAt(i)-'0']++;
            }
        }
        System.out.println(Math.min(count[0], count[1]));
    }
}
