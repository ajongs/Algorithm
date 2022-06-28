import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String[] str = br.readLine().split(" ");
        
            int n1 = Integer.parseInt(str[0]);
            int n2 = Integer.parseInt(str[1]);
            
            if(n1==0 && n2 ==0){
                break;
            }
            
            if(n1 > n2){ //이 경우는 n1이 n2의 배수는 경우 검사
                if(n1%n2==0){
                    System.out.println("multiple");
                }
                else{
                    System.out.println("neither");
                }
            }
            else{
                if(n2%n1==0){
                    System.out.println("factor");
                }
                else{
                    System.out.println("neither");
                }
            }
        }
        
    }
}
