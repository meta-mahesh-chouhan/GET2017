import java.util.Iterator;


public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		System.out.println("*******************Adding Elements*******************");
		
		//Add elements to list
		list.addElement("Mahesh");
		list.addElement("Chouhan");
		list.addElement("Udit");
		list.addElement("abhishek");
		list.addElement("chouhan");
		list.addElement("akshay");

		
		//Iterator to iterate over linked list
		Iterator<String> iterator = list.iterator();
		
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
		
		System.out.println("*******************Removing element at index 1*******************");
		//Remove by Index
		list.removeByIndex(1);
		
		iterator = list.iterator();
		
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
		
		
		System.out.println("*******************Adding Element 'chouhan' at index 1*******************");
		//Add element at given index
		list.addElement(1, "chouhan");
		
		iterator = list.iterator();
		
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
		
		
		System.out.println("************Adding Elements at index 6 thorws exception************");
		try{
		//Adding element at index greater than size
		list.addElement(6, "chouhan");
		}
		catch (Exception e){
			System.out.println(e+"\n");
		}
		System.out.println("*******************Removing element 'chouhan' by value*******************");
		
		//Remove by value
		list.removeByValue("chouhan");
		
		iterator = list.iterator();
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		System.out.println();
		
		System.out.println("*******************Create ArrayList of Integer type*******************");
		
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		
		numberList.addElement(12);
		numberList.addElement(22);
		numberList.addElement(20);
		numberList.addElement(50);
		
		Iterator<Integer> iteratorNumber = numberList.iterator();
		while (iteratorNumber.hasNext()){
			System.out.println(iteratorNumber.next());
		}
		System.out.println();
		
		System.out.println("*******************Sorting the Number arraylist*******************");
		
		numberList.sort();
		
		iteratorNumber = numberList.iterator();
		while (iteratorNumber.hasNext()){
			System.out.println(iteratorNumber.next());
		}
		
		System.out.println("*************************Reverse the ArrayList*******************");
		
		numberList.reverse();
		
		iteratorNumber = numberList.iterator();
		while (iteratorNumber.hasNext()){
			System.out.println(iteratorNumber.next());
		}
		
		//Adding sublist to a given list
		ArrayList<Integer> subList = new ArrayList<Integer>();
		
		subList.addElement(22);
		subList.addElement(28);
		
		System.out.println("*************************Adding SubList[ 22,28 ] To current List*******************");
		
		numberList.addList(subList);
		
		
		iteratorNumber = numberList.iterator();
		
		while (iteratorNumber.hasNext()){
			System.out.println(iteratorNumber.next());
		}
		System.out.println();
		
		//Getting first occurence of given element
		
		
		System.out.println("*************************First Occurence of 22*******************");
		System.out.println(numberList.firstOccurence(22));
		
		System.out.println();
		
		//Getting first occurence of given element after given location
		System.out.println("*************************First Occurence of 22 after postion 3*******************");
		System.out.println(numberList.firstOccurence(22,3));
		
		
		
		
		
	}

}
