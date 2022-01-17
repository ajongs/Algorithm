import java.io.*;
import java.util.*;
class Main {
  static List<Integer>[] map;
  static boolean[] visited;
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int roopCount =1;
    while(true){
      String[] st = br.readLine().split(" ");
      int n = Integer.parseInt(st[0]);
      int m = Integer.parseInt(st[1]);
      if(n==0 && m==0){
        break;
      }
      //0인덱스 사용 안할 거임
      map = new ArrayList[n+1];
      visited = new boolean[n+1];
      for(int i=1; i<n+1; i++){
        map[i] = new ArrayList<>();
      }
      
      for(int i=0; i<m; i++){
        String[] str = br.readLine().split(" ");
        int v = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);
        map[v].add(e);
        map[e].add(v);
      }
      
      int count=0;
      for(int i=1; i<n+1; i++){
        if(!visited[i]){
          count += checkTree(i);
        }
      }
      
      if(count ==0){
        System.out.println("Case "+ roopCount++ +": No trees.");
      }
      else if(count ==1 ){
        System.out.println("Case "+ roopCount++ +": There is one tree.");
      }
      else if(count > 1){
        System.out.println("Case "+ roopCount++ +": A forest of "+count + " trees.");
      }
    }
    
  }
  static int checkTree(int start){
    Queue<Integer> q = new LinkedList<>();
    q.offer(start);
    int v=0;
    int e=0;
    while(!q.isEmpty()){
      int current = q.poll();
      visited[current] = true;
      v+=1;
      
      for(int i=0; i<map[current].size(); i++){
        int next = map[current].get(i);
        e +=1;
        if(!visited[next]){
          q.offer(next);
        }
      }
    }
    return e/2 +1==v?1:0;
  }
}
