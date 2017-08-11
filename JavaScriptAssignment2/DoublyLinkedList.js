/*
 * Node class creates a node and initializes with given value and next pointing to null.
 */
function Node(value) {
	this.value = value;
	this.next = null;
	this.previous = null;
}

/*
 * Creates a Singly Linked list with head initialized to null.
 */
function DoublyLinkedList() {
	this.head = null;
	this.length = 0;

	// Adds a new node to linked list and return updated head of the list.
	this.addNode = function(value) {

		if(value != ""){

		var newNode = new Node(value);

		// display that value is added to list.
		document.getElementById("addList").innerHTML = value + " added to List";

		// If list is empty, point head node to new node.
		if (this.head == null) {
			this.head = newNode;
			this.length++;

		}
		else{
		// Otherwise, traverse to the end of list
		var iterator = this.head;
		while (iterator.next) {
			iterator = iterator.next;
		}

		// Point the last node to new node.
		iterator.next = newNode;
		newNode.previous = iterator;
		this.length++;
		}
		}
		else{
		document.getElementById("addList").innerHTML = "Empty : Write Something";
		}
	
	};

	// Prints the values of all the nodes of linked list.
	this.printList = function() {

		if (this.head == null) {
			return "List is empty";
		}
		var iterator = this.head;
		var result = "";
		while (iterator) {
			result += "<br/>" + iterator.value;
			iterator = iterator.next;
		}
		return result;

	};

	// Prints the values of all the nodes of linked list.
	this.printReverse = function() {

		if (this.head == null) {
			return "List is empty";
		}
		var iterator = this.head;
		var result = "";
		var lastNode;
		while (iterator) {
			lastNode=iterator;
			iterator = iterator.next;
		}
		
		iterator=lastNode;
		while(iterator){
			result += "<br/>" + iterator.value;
			iterator=iterator.previous;
			
		}
		return result;

	};
	// Returns indexes of search values
	this.searchNode = function(value) {

		var result = "";
		if( value.toString().trim() == ""){
			result = "Empty : Write Something";
		}
		else if (this.head == null)
			result += "List is empty";
		else {
		var iterator = this.head;
		var indexCounter = 1;
		var positionArray = new Array();
		var resultArrayIndex = 0;
		while (iterator) {

			if (value == iterator.value) {
				positionArray[resultArrayIndex++] = indexCounter;

			}

			iterator = iterator.next;
			indexCounter++;
		}
		// If element not found
		if (resultArrayIndex == 0)
			result += "Element Not found !";
		else
			// Return indexes of found values.
			result = positionArray;
		}
		return result;
	};

	// Removes node at given position.
	this.removeNode = function(position) {

		var result = "";
		var previous = this.head;
		var iterator = this.head;

		if( position.toString().trim() == ""){
			result = "Empty : Write Something";
		}
		else if (this.head == null) {
			result = "List is empty";
		}else if ( this.head.next == null ){
			//If only one element in list
			this.head = null;
		}else if (position == 1) {
			// If first node is removed.
			result = this.head.value + " successfully removed";	
			this.head.next.previous = null;
			this.head = this.head.next;
			this.length--;
		} else if ( position == this.length){
			// Removing last node.
			var lastNode = this.head;

			while(lastNode.next){
				lastNode = lastNode.next;
			}

			lastNode.previous.next = null;
			delete lastNode;
			this.length--;

		}else if(position < this.length && position > 0){
			// Removing middle nodes
			var index = 1;

			while (index < position) {
				previous = iterator;
				iterator = iterator.next;
				index++;
			}
			previous.next = iterator.next;
			iterator.next.previous=previous;
			delete iterator;
			this.length--;
			result = iterator.value + " successfully removed";

		}
		 else {
				result = "Enter correct Position";
			}

		return result;
	};
}

// Onclick to add new element to linked list.
function addNewNode() {
	linkedList.addNode(document.getElementById("value").value);
	document.getElementById("value").value = "";
	print();
	printReverse();

};

// Onclick to print all the elements of linked list.
function print() {
	var result = linkedList.printList();
	document.getElementById("printList").innerHTML = result;
	document.getElementById("value").value = "";

};

//Onclick to print all the elements of linked list in Reverse Order.
function printReverse() {
	var result = linkedList.printReverse();
	document.getElementById("printReverse").innerHTML = result;
	document.getElementById("value").value = "";

};
// Onclick to return index of searched element.
function searchList() {
	document.getElementById("searchList").innerHTML = linkedList.searchNode(document.getElementById("value").value);
	document.getElementById("value").value = "";
	document.getElementById("addList").innerHTML = "";
};

// Onclick to remove an element from linked list.
function removeResult() {
	document.getElementById("removeResult").innerHTML = linkedList.removeNode(document.getElementById("value").value);
	document.getElementById("value").value = "";
	document.getElementById("addList").innerHTML = "";
	document.getElementById("searchList").innerHTML = "";
	print();
	printReverse();
}


// Create an object of Singly Linked List.
var linkedList = new DoublyLinkedList();
