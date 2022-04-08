import java.io.*;

class Main{
    static int[] coin;
    static int k;
    static int n;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);

        coin = new int[n];

        for(int i=0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(greedy());
    }
    public static int greedy(){
        int cur=0;
        int answer =0;
        int sum=0;

        int cpk=k;
        while(sum != k){
            //먼저 k원에 가까운 최대크기의 동전 구해서 for문 돌리기
            for(int i=0; i<n; i++){
                if(coin[i] > cpk && i>0){
                    cur = i-1;
                    break;
                }
                else if(i==n-1){
                    cur = i;
                }
            }
            //k보다 작기전까지 넣어야함
            int roofSum=0;
            while(roofSum <= cpk){
                roofSum += coin[cur];
                answer++;
            }
            roofSum = roofSum - coin[cur];
            answer--;
            sum += roofSum;
            cpk -= roofSum;
        }
        return answer;
    }
}
