import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		int randomRange = 100;
		DoublyLinkedListClass<Integer> testList = new DoublyLinkedListClass<Integer>();
		for(int i = 0; i<100; i++) {
			testList.addAtHead(rand.nextInt(randomRange));
		}
		testList.printList();
		int guess = 0;
		Scanner input = new Scanner(System.in);
		
		while(guess!=5) {
			System.out.println("Enter an integer: ");
			int number = input.nextInt();
			guess++;
			if(testList.contains(number)) {
				System.out.println("Correct guess");
			}else {
				System.out.println("Wrong guess");
			}
			
		}
		
		
	}

}
