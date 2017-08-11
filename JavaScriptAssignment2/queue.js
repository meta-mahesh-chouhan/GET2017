/*
 * Node class creates a node and initializes with given value and next pointing to null.
 */
function Node(data) {
	this.data = data;
	this.next = null;
}

/*
 * Linked list implementation of Queue.
 */
function Queue() {
	this.front = null;
	this.rare = null;

}
/*
 * Insert into Queue from rare.
 */
Queue.prototype.enqueue = function(value) {

	if (value.toString().trim() == "") {
		return "Empty : Write Something";
	} else {
		var newNode = new Node(value);

		if (!this.front) {
			this.front = newNode;
			this.rare = newNode;
		} else {

			this.rare.next = newNode;
			this.rare = this.rare.next;
		}

		return value + " inserted into queue";
	}
}

/*
 *Remove from queue from front.  
 */
Queue.prototype.dequeue = function() {

	var result = "";
	if (!this.front) {
		result = "Empty Queue";
	} else {
		var temp = this.front;
		this.front = this.front.next;
		result = temp.data + " deleted";
		delete temp;

	}
	return result;
}

/*
 * Prints the elements of Queue.
 */
Queue.prototype.printQueue = function() {

	var result = "";

	if (!this.front) {
		result = "Empty Queue";
	} else {
		var iterator = this.front;

		while (iterator) {
			result += iterator.data + "<br/>";
			iterator = iterator.next;
		}
	}
	return result;
}
/*
 * Returns the element at front of Queue.
 */
Queue.prototype.peek = function() {

	if (this.front == null) {
		return "Empty Queue";
	}
	return this.front.data;
}
/*
 * onClick to handle Enqueue operation
 */
function onClickEnqueue(){
	document.getElementById("enqueueDisplay").innerHTML = queue.enqueue(document.getElementById("value").value);
	document.getElementById("dequeueDisplay").innerHTML = "";
	document.getElementById("value").value = "";
	onClickPeek();
	onClickPrintQueue();
	
}

/*
 * onClick to handle Dequeue operation
 */
function onClickDequeue(){
	document.getElementById("dequeueDisplay").innerHTML = queue.dequeue();
	document.getElementById("enqueueDisplay").innerHTML = "";
	onClickPrintQueue();
	onClickPeek();
}

/*
 * onClick to Print Queue elements.
 */
function onClickPrintQueue(){
	document.getElementById("printDisplay").innerHTML = queue.printQueue();	
}

/*
 * ocClick to peek element a front.
 */
function onClickPeek(){
	document.getElementById("peekDisplay").innerHTML = queue.peek();
	
}

var queue = new Queue();

