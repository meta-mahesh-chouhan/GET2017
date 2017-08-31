import java.util.Iterator;


public class Main {
	
	public static void main(String[] args) {
		DoublyLinkedList<String> linkedList = new DoublyLinkedList<String>();
		
		System.out.println("************************Adding elements to Linked list************************");
		

		//Add elements to linked list
		linkedList.addElement("mahesh");
		linkedList.addElement("chouhan");
		linkedList.addElement("udit");
		linkedList.addElement("saxena");
		linkedList.addElement("abhishek");
		
		Iterator<String> iterator = linkedList.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
		
		//Priniting list in reverse to check previous pointers
		System.out.println("************************Printing in reverse to check previous pointers************************");
		
		DoublyLinkedListNode<String> last = linkedList.getHead();
		
		while ( last.getNext() != null ){
			last = last.getNext();
		}
		
		while( last != null){
			System.out.println(last.getData());
			last = last.getPrevious();
		}
		
		System.out.println("*******************Removing element at index 2*******************");
		//Remove element at index 2
		linkedList.removeByIndex(2);
		
		iterator = linkedList.iterator();
		
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
		

		//Priniting list in reverse to check previous pointers
		System.out.println("************************Printing in reverse to check previous pointers************************");
		
		 last = linkedList.getHead();
		
		while ( last.getNext() != null ){
			last = last.getNext();
		}
		
		while( last != null){
			System.out.println(last.getData());
			last = last.getPrevious();
		}
		
		System.out.println("*******************Adding Element 'chouhan' at index 3*******************");
		//Add element at given index

		linkedList.addElement("chouhan",3);
		iterator = linkedList.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
		

		//Priniting list in reverse to check previous pointers
		System.out.println("************************Printing in reverse to check previous pointers************************");
		
		 last = linkedList.getHead();
		
		while ( last.getNext() != null ){
			last = last.getNext();
		}
		
		while( last != null){
			System.out.println(last.getData());
			last = last.getPrevious();
		}
		
		
		System.out.println("*******************Removing Element 'mahesh' by index******************");
		//Remove element at given index

		linkedList.removeByIndex(0);
		iterator = linkedList.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
	
		//Priniting list in reverse to check previous pointers
		System.out.println("************************Printing in reverse to check previous pointers************************");
		
		 last = linkedList.getHead();
		
		while ( last.getNext() != null ){
			last = last.getNext();
		}
		
		while( last != null){
			System.out.println(last.getData());
			last = last.getPrevious();
		}
		
		System.out.println("*******************Removing Element 'chouhan' by value******************");
		//Remove element at given index

		linkedList.removeByValue("chouhan");;
		iterator = linkedList.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
		

		//Priniting list in reverse to check previous pointers
		System.out.println("************************Printing in reverse to check previous pointers************************");
		
		 last = linkedList.getHead();
		
		while ( last.getNext() != null ){
			last = last.getNext();
		}
		
		while( last != null){
			System.out.println(last.getData());
			last = last.getPrevious();
		}
		
		
		//Create a linked list
		System.out.println("*******************Creating a linked list of Integer******************");
		
		LinkedList<Integer> numberList = new LinkedList<Integer>();
		
		numberList.addElement(10);
		numberList.addElement(40);
		numberList.addElement(30);
		numberList.addElement(20);
		
		Iterator<Integer> numberIterator = numberList.iterator();
		
		while(numberIterator.hasNext()){
			System.out.println(numberIterator.next());
		}
		
		//Sort the linked list
		System.out.println("\n*******************Sorting the linked list******************");
		numberList.sort();
		numberIterator = numberList.iterator();
		
		while (numberIterator.hasNext()){
			System.out.println(numberIterator.next());
		}
		
		//Reverse th linked list
		System.out.println("\n*******************Reverse the linked list******************");
		numberList.reversal();
		numberIterator = numberList.iterator();
		
		while (numberIterator.hasNext()){
			System.out.println(numberIterator.next());
		}
		
		//Get element at given index
		System.out.println("\n*******************Get Element At Index 2******************");
		System.out.println(numberList.getElement(2));
		
		
		//Remove element with invalid index
		System.out.println("\n*******************Remove element at index 5 generates exception******************");
		try{
			numberList.removeByIndex(5);
		}catch(IllegalArgumentException e){
			System.out.println(e);
		}
		//Insert Element at invalid index
		System.out.println("\n*******************Insert element at index 10 generates exception******************");
		try{
			numberList.removeByIndex(10);
		}catch(IllegalArgumentException e){
			System.out.println(e);
		}
	}

}
