import java.io.*;
import java.util.*;
class Main{


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        List<Input> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            String[] str = br.readLine().split(" ");
            ans.add(new Input(Integer.parseInt(str[0]), Integer.parseInt(str[1])));

        }

        for(int i=0; i<n; i++){
            int[] dist = new int[100000];
            int[] from = new int[100000];
            String[] how = new String[100000];
            boolean[] check = new boolean[100000];

            Queue<Integer> q = new LinkedList<>();
            Input item = ans.get(i);
            q.offer(item.a);
            dist[item.a] = 0;

            while(!q.isEmpty()){
                int now = q.poll();
                for(int j=0; j<4; j++){
                    if(j==0){
                        //D 연산
                        int next = (now*2) % 10000;
                        if(check[next] == false){
                            q.offer(next);
                            check[next] = true;
                            dist[next] = dist[now]+1;
                            from[next] = now;
                            how[next] = "D";
                        }
                    }

                    else if(j==1) {
                        //S 연산
                        int next = now -1;
                        if(now ==0) next = 9999;
                        if(check[next] == false){
                            q.offer(next);
                            check[next] = true;
                            dist[next] = dist[now]+1;
                            from[next] = now;
                            how[next] = "S";
                        }
                    }
                    else if(j==2){
                        //L 연산
                        int next = (now%1000)*10 + now/1000;
                        if(check[next] == false){
                            q.offer(next);
                            check[next] = true;
                            dist[next] = dist[now]+1;
                            from[next] = now;
                            how[next] = "L";
                        }

                    }
                    else{
                        //R 연산
                        int next = now%1000 + (now%10)*1000;
                        if(check[next] == false){
                            q.offer(next);
                            check[next] = true;
                            dist[next] = dist[now]+1;
                            from[next] = now;
                            how[next] = "R";
                        }
                    }
                }

            }

            StringBuilder sb = new StringBuilder();
            int B = item.b;
            int A = item.a;
            while(B != A){
                sb.append(how[B]);
                B = from[B];
            }
            System.out.println(sb.reverse());
        }

    }
    static class Input{
        int a;
        int b;

        Input(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
}
