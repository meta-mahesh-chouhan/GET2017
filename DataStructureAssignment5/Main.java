

public class Main {
	
	public static void main(String[] args) {
		System.out.println("*******************Concordance string for string 'Hello World'***************************\n");
		Concordance c = new Concordance();
		System.out.println(c.printConcordance(args));
		
		
		System.out.println("\n*******************Inserting elements into queue***************************\n");
		Queue<String> queue = new Queue<String>();
		
		queue.enqueue("mahesh");
		queue.enqueue("chouhan");
		queue.enqueue("udit");
		queue.enqueue("saxena");
	

		System.out.println(queue.print());
		
		System.out.println("\n*******************Inserting elements into Sorted Linked List***************************\n");
		SortedLinkedList<Integer> link = new SortedLinkedList<Integer>();
		
		link.add(1);
		link.add(2);
		link.add(10);
		link.add(7);
		link.add(3);
		link.add(4);
		
		System.out.println(link.print());
		
	}
}
