import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        return bfs(begin, target, words);
    }
    public static int bfs(String begin, String target, String[] words){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));
        while(!q.isEmpty()){
            Node current = q.poll();

            if(current.word.equals(target)){
                return current.depth;
            }

            for(int i=0 ; i< words.length; i++){
                int count =0;
                for(int j=0; j<begin.length(); j++){
                    if(current.word.charAt(j)==words[i].charAt(j)){
                        count++;
                    }
                }
                if(count== begin.length()-1 && visited[i] ==false){
                    visited[i] = true;
                    q.offer(new Node(words[i], current.depth + 1));
                }
            }
        }

        return 0;
    }
    static class Node{
        String word;
        int depth;

        Node(String word, int depth){
            this.word=word;
            this.depth = depth;
        }
    }
}
