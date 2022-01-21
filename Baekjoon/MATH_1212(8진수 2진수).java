// import java.util.Scanner;

// class Main{
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);
//         String n = sc.nextLine();

//         StringBuilder sb = new StringBuilder();
//         for(int i=0; i<n.length(); i++){
//             int num = n.charAt(i)-'0';
//             if(n.length()==1 && num==0) sb.append(0);   //0일때 처리 주의하자
//             if(i==0){
//                 while(num!=0){
//                     sb.append(num%2);
//                     num /= 2;
//                 }
//             }
//             else{
//                 for(int j=0; j<3; j++){
//                     if(num==0){
//                         sb.append(num);
//                         continue;
//                     }
//                     sb.append(num%2);
//                     num /= 2;
//                 }
//             }
//             System.out.print(sb.reverse());
//             sb.setLength(0);
//         }
//         System.out.println();

//     }
// }

import java.util.Scanner;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        String[] eight = {"000", "001","010","011","100","101","110","111"};
        if (n.length() == 1 && n.charAt(0) == '0') {
            System.out.print(0);
        }
        for(int i=0; i<n.length(); i++){
            int num = n.charAt(i)-'0';
            if(i==0){
                if(num==0){
                    continue;
                }
                if(num==1){
                    System.out.print("1");
                }
                else if(num==2){
                    System.out.print("10");
                }
                else if(num==3){
                    System.out.print("11");
                }
                else
                System.out.print(eight[num]);
            }
            else
                System.out.print(eight[num]);
        }
        System.out.println();

    }
}
