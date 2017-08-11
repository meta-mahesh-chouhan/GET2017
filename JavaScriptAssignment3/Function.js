/*
 * Returns sum of first and second number
 */
function sum(firstNumber, secondNumber) {
	
	if(firstNumber.trim() == "" || secondNumber.trim() == "" || isNaN(firstNumber) || isNaN(secondNumber)){
		return "Enter Number";
	}
	else{
	// If second nnumber is not passed in arguments
	if (secondNumber === undefined) {
		return function(thirdNumber) {
			return parseInt(firstNumber) + parseInt(secondNumber);
		};
	}
	return parseInt(firstNumber) + parseInt(secondNumber);
	
	}
}

/*
 * onClick to handle sum
 */
function onClickSum(){
	document.getElementById("display").innerHTML=sum(document.getElementById("firstNumber").value,document.getElementById("secondNumber").value);
}