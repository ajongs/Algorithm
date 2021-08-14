import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input;
        Tree tree = new Tree();
        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            //System.out.println(input[0].charAt(0)+" "+ input[1].charAt(0)+" "+ input[2].charAt(0));
            tree.add(input[0].charAt(0), input[1].charAt(0), input[2].charAt(0));
        }
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);
        System.out.println();
    }
}
class Node{
    char data;
    Node leftNode;
    Node rightNode;
    Node(char data){
        this.data = data;
    }
}
class Tree{
    public Node root;

    Tree(){

    }
    public void add(char data, char left, char right){
        if(root==null){
            root = new Node(data);
            if(left!='.')
                root.leftNode = new Node(left);
            if(right!='.')
                root.rightNode = new Node(right);
        }
        else{
            Node node = search(root, data);
            if(node==null){
                return;
            }
            if(left!='.')
                node.leftNode = new Node(left);
            if(right!='.')
                node.rightNode = new Node(right);
        }
    }
    public Node search(Node root, char data){
        if(root==null){
            return null;
        }
        else if(root.data == data){
            return root;
        }
        else{
            Node node1 = search(root.leftNode, data);
            Node node2 = search(root.rightNode, data);
            if(node1!=null){
                return node1;
            }
            return node2;
        }
    }
    public void preOrder(Node root){
        System.out.print(root.data);
        if(root.leftNode !=null)
            preOrder(root.leftNode);
        if(root.rightNode != null)
            preOrder(root.rightNode);
    }
    public void inOrder(Node root){
        if(root.leftNode !=null)
            inOrder(root.leftNode);
        System.out.print(root.data);
        if(root.rightNode != null)
            inOrder(root.rightNode);
    }
    public void postOrder(Node root){
        if(root.leftNode !=null)
            postOrder(root.leftNode);
        if(root.rightNode != null)
            postOrder(root.rightNode);
        System.out.print(root.data);
    }
}
