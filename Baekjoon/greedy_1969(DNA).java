import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        String[] input = new String[n];
        for(int i=0; i<n; i++){
            input[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        int hammingDistance =0;
        for(int j=0; j<m; j++){
            int[] temp = new int[4];

            for(int i=0; i<n; i++){
                if(input[i].charAt(j) == 'A'){
                    temp[0]++;
                }
                else if(input[i].charAt(j) == 'C'){
                    temp[1]++;
                }
                else if(input[i].charAt(j) == 'G'){
                    temp[2]++;
                }
                else {
                    temp[3]++;
                }
            }
            int idx=0;
            for(int i=1; i<4; i++){
                if(temp[idx] < temp[i]){
                    idx = i;
                }
            }
            hammingDistance += n - temp[idx];
            if(idx == 0) {
                sb.append("A");
            }else if(idx ==1){
                //c
                sb.append("C");
            }else if(idx ==2){
                //g
                sb.append("G");
            }else{
                //t
                sb.append("T");
            }
        }

        System.out.println(sb.toString());
        System.out.println(hammingDistance);

    }
}
