import java.io.*;
import java.util.*;
class Main{
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        int[] subArray = new int[n-1];
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<n-1; i++){
            subArray[i] = Math.abs(array[i] - array[i+1]);
        }

        int gcd;
        if(n>2){
            gcd = euclidean(subArray[0], subArray[1]);
            for(int i=2; i<n-1; i++){
                gcd = euclidean(gcd, subArray[i]);

            }
        }
        else{
            gcd = subArray[0];
        }

        makeDivisor(gcd);
        for (Integer i : list) {
            System.out.print(i+" ");
        }
    }
    static void makeDivisor(int gcd){
        for(int i=2; i<=Math.sqrt(gcd); i++){
            if(gcd%i==0){
                list.add(i);
            }
        }
        int size = list.size();
        for(int i=0; i<size; i++){
            if(list.get(i)*list.get(i) == gcd){
                continue;
            }
            list.add(gcd/list.get(i));
        }
        list.add(gcd);
        Collections.sort(list);
    }
    static int euclidean(int n1, int n2){
        if(n1>n2){
            if(n1%n2==0){
                return n2;
            }
            else{
                return euclidean(n1%n2, n2);
            }
        }
        else{
            if(n2%n1==0){
                return n1;
            }
            else{
                return euclidean(n1, n2%n1);
            }
        }
    }
}
