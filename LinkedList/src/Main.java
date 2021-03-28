import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		int randomRange = 100;
		LinkedListClass<Integer> testList = new LinkedListClass<Integer>();
		testList.addAtHead(22);
		testList.addAtHead(3000);
		testList.addAtHead(33);
		testList.addAtTail(999);
		testList.addAtIndex(23,1);
		System.out.println(testList.getCurrentSize());
		if(testList.contains(23)) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		for(int i=0; i<= testList.getCurrentSize(); i++) {
			System.out.println("Element");
			System.out.println(testList.getAtIndex(i));
		}
		
	}

}
