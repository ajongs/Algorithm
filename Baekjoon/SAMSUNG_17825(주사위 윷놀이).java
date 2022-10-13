import java.io.*;
public class Main {

	static Node start;
	static int[] dice;
	static int[] order;
	static Node[] horse = new Node[4]; 
	static int answer = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		dice = new int[str.length];
		order = new int[str.length];
		for(int i=0; i<str.length; i++) {
			dice[i] = Integer.parseInt(str[i]);
		}
		
		init();
		permutate(0);
		
		System.out.println(answer);
		
	}
	static void permutate(int depth) {
		if(depth == 10) {
			answer = Math.max(answer, calculrate());
			return;
		}
		for(int i=0; i<4; i++) {
			order[depth] = i;
			permutate(depth+1);
		}
	}
	static int calculrate() {
		int score=0;
		for(int i=0; i<4; i++) {
			horse[i] = start;
		}
		
		for(int i=0; i<10; i++) {
			Node cur = horse[order[i]];
			cur.isEmpty = true;
			
			for(int j=0; j<dice[i]; j++) {
				if(j==0 && cur.shortNext!=null) {
					cur = cur.shortNext;
				}else
					cur = cur.next;
			}
			horse[order[i]] = cur;
			
			//해당자리에 있는가?
			if(!cur.isEmpty && !cur.finish) {
				score = 0;
				break;
			}
			score += cur.score;
			cur.isEmpty = false;
		}
		rollback();
		return score;
	}
	static void rollback() {
		for(int i=0; i<4; i++) {
			horse[i].isEmpty = true; //이전 결과 삭제
		}
	}
	static void init() {
		start = new Node(0); //시작점 
		Node temp = start;
		for(int i=2; i<=40; i+=2) {
			temp = temp.addNext(new Node(i));
		}
		Node end = temp.addNext(new Node(0));
		end.finish = true;
		end.next = end; //도착지점 넘어선것 nullp 방지
		
		Node cross = new Node(25);
		
		//10에서 빠른 길 초기화
		Node ten = start.getScore(10);
		for(int i=3; i<=9; i+=3) {
			if(i==3) {
				temp = ten.addShortNext(new Node(10+i));
			}
			else
				temp = temp.addNext(new Node(10+i));
		}
		temp.addNext(cross);
		
		//20에서 빠른길 초기화
		temp = start.getScore(20);
		for(int i=2; i<=4; i+=2) {
			if(i==2) {
				temp = temp.addShortNext(new Node(20+i));
			}
			else
				temp = temp.addNext(new Node(20+i) );
		}
		temp.addNext(cross);
		
		
		//30에서 빠른길 초기화
		temp = start.getScore(30);
		for(int i=28; i>=26; i--) {
			if(i==28) {
				temp = temp.addShortNext(new Node(i));
			}
			else
				temp = temp.addNext(new Node(i));
		}
		temp.addNext(cross);
		
		temp = cross;
		for(int i=30; i<=35; i+=5) {
			temp = temp.addNext(new Node(i));
		}
		temp.addNext(start.getScore(40));
		
		
	}
	static private class Node{
		int score;
		boolean isEmpty;
		boolean finish;
		Node next;
		Node shortNext;
		
		Node(int score){
			this.score = score;
			isEmpty = true;
		}
		
		public Node addNext(Node next) {
			this.next = next;
			return next;
		}
		public Node addShortNext(Node shortNext) {
			this.shortNext = shortNext;
			return shortNext;
		}
		public Node getScore(int score) {
			Node temp = this;
			while(true) {
				if(temp.score == score) {
					return temp;
				}
				if(temp == null) return null;
				temp = temp.next;
			}
		}
	}
}
