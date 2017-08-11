/*
 * Node class creates a node and initializes with given value and next pointing to null.
 */
function Node(data) {
	this.data = data;
	this.next = null;
}

/*
 * Linked list implementation of Stack.
 */
function Stack() {
	this.top = null;

}
/*
 * Pushes element to top of stack.
 */
Stack.prototype.push = function(data){
	
		
		if(data == ""){
		return "Empty :Write Something";
		
		}
		else{
		var newNode = new Node(data);
		newNode.next = this.top;
		this.top = newNode;
		return data+" Pushed into Stack";
		}
	
}



/*
 * Pops element from top of stack.
 */
Stack.prototype.pop = function() {

	if (this.top == null) {
		return "Empty Stack";
	}

	var temp = this.top;
	this.top = this.top.next;

	delete temp;
	return temp.data + " popped from Stack";
}

/*
 * Returns element at top of Stack.
 */
Stack.prototype.peek = function() {

	if (this.top == null) {
		return "Empty Stack";
	}

	return this.top.data + " is at top of Stack";
}



/*
 * Prints the Stack.
 */
Stack.prototype.print = function() {

	if (this.top == null) {
		return "Empty Stack";
	}

	var result = "";
	var iterator = this.top;
	while (iterator) {
		result += iterator.data + "<br/>";
		iterator = iterator.next;
	}

	return result;

}

// OnClick to push element into stack
function onClickPush() {
	
	document.getElementById("pushDisplay").innerHTML = stack.push(document.getElementById("value").value);;
	document.getElementById("value").value = "";
	document.getElementById("popDisplay").innerHTML = "";
	onClickPeek();
	onClickPrint();
}

//OnClick to pop element from stack
function onClickPop() {
	document.getElementById("popDisplay").innerHTML = stack.pop();
	document.getElementById("pushDisplay").innerHTML = "";
	onClickPeek();
	onClickPrint();
}

//OnClick to peek element from stack
function onClickPeek() {
	document.getElementById("peekDisplay").innerHTML = stack.peek();
}

//OnClick to print elements of stack
function onClickPrint() {
	document.getElementById("printDisplay").innerHTML = stack.print();
}

var stack = new Stack();