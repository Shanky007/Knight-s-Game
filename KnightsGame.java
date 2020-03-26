import java.util.Random;

public class KnightsGame {
	
	//Node class
	static class Knight{
		public int name;
		public int health;
		
		public Knight next;
		
		public Knight(int name, int health) {
			this.name = name;
			this.health = health;
		}
		
	}
	
	//generate this random number
	static int generateRandomNumber(int min, int max) {
		Random r = new Random();
		return r.nextInt((max-min)+1)+min;
	}
	
	
	//method which prints the last knight standing
	static void lastKnightStanding(int n) {
		
		//creating the nodes
		Knight head = new Knight(1, 100);
		Knight tail = head;
		
		for(int i=2; i<=n; i++) {
			tail.next = new Knight(i, 100);
			tail = tail.next;
		}
		tail.next = head;
		
		//traversal and attack
		Knight attackingKnight = head, receivingKnight = head;
		
		while(attackingKnight.next != attackingKnight) {
			receivingKnight = attackingKnight.next;
			
			//k1 hits k2
			int damage = generateRandomNumber(1, 6);
			receivingKnight.health = receivingKnight.health - damage;
			System.out.println("K"+ attackingKnight.name+ " hits K"+ receivingKnight.name + " by "+ damage +" damage points");
			if(receivingKnight.health < 1) {
			    System.out.println("K"+ receivingKnight.name +" dies");
				attackingKnight.next = receivingKnight.next;
				attackingKnight = receivingKnight.next;
				receivingKnight = attackingKnight.next;
			
			}
			else {
				attackingKnight = receivingKnight;
				receivingKnight = attackingKnight.next;
			}
			
		}
		System.out.println("K"+ attackingKnight.name + " wins the game");
				
	}
	public static void main(String[] args) {
		lastKnightStanding(6);
	}

}
