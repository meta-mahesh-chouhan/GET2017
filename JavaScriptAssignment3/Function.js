/*
 * Returns sum of first and second number
 */
function sum(firstNumber, secondNumber) {
	
	// If second nnumber is not passed in arguments
	if (secondNumber === undefined) {
		return function(thirdNumber) {
			return parseInt(firstNumber) + parseInt(thirdNumber);
		};
	}
	return parseInt(firstNumber) + parseInt(secondNumber);
	
}

/*
 * onClick to handle sum(firstNumber,secondNumber)
 */
function onClickSum1(){
	
	if(checkEmptyFields())
	{
	document.getElementById("display").innerHTML = sum(document.getElementById("firstNumber").value , document.getElementById("secondNumber").value);
	}
	else{
	document.getElementById("display").innerHTML = "Enter Number";
	}
}

/*
 * onClick to handle sum(firstNumber)(secondNUmber)
 */
function onClickSum2(){
	if(checkEmptyFields())
	{
	document.getElementById("display").innerHTML = sum(document.getElementById("firstNumber").value )( document.getElementById("secondNumber").value);
	}
	else{
	document.getElementById("display").innerHTML = "Enter Number";
	}
}
/*
 * Check if the fields are empty
 */
function checkEmptyFields(){
	var firstNumber = document.getElementById("firstNumber").value;
	var secondNumber = document.getElementById("secondNumber").value;
	
	if(firstNumber.trim() == "" || isNaN(firstNumber) || secondNumber.trim() == "" || isNaN(secondNumber)){
		return false;
	}
	
	return true;
	
}
