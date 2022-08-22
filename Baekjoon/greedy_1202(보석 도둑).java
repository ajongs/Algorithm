import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);
        Jewel[] jewels = new Jewel[n];
        int[] bags = new int[k];
        for(int i=0; i<n; i++){
            str = br.readLine().split(" ");
            int weight = Integer.parseInt(str[0]);
            int price = Integer.parseInt(str[1]);
            jewels[i] = new Jewel(weight, price);
        }
        for(int i=0; i<k; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        Arrays.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                if(o1.weight == o2.weight){
                    return o2.price - o1.price;
                }
                return o1.weight - o2.weight;
            }
        });
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        long result=0;

        for(int i=0, j=0; i<k; i++) {
            int bagWeight = bags[i];

            while(j<n && jewels[j].weight <= bagWeight){
                q.offer(jewels[j++].price);
            }
            if(!q.isEmpty()){
                result += q.poll();
            }
        }
        System.out.println(result);
    }
}
class Jewel{
    int weight;
    int price;

    public Jewel(int weight, int price){
        this.weight = weight;
        this.price = price;
    }
}
