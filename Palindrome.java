
public class Palindrome {

	static void palindrome(int limit) {
		System.out.println("Pallindromes found until "+limit+" :");
		for(int i=0; i<limit; i++) {
			String string = Integer.toString(i);
			String reverseString = new StringBuilder(string).reverse().toString();
			if(string.equals(reverseString)) {
				System.out.println(i);
			}
		}		
	}
	public static void main(String[] args) {
		palindrome(1000);
	}
}
