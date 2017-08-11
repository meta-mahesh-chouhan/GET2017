
function removeDuplicates() {

	var str = document.getElementById("input").value.trim();
	

	var prevPos = 0;
	var curPos = 0;
	var curLength = 0;
	var result = str;
	
	//if input string is empty
	if (str.length == 0) {
		result = "Empty:Insert an element";
	} else {
		
		while (curPos < str.length) {
			
			if (str.charAt(prevPos) == str.charAt(curPos)) {
				//On finding same character
				curPos++;
				curLength++;
			} else if (curLength > 1) {
				str = str.slice(0, prevPos) + str.slice(curPos);
				result += "->" + str;
				prevPos = 0;
				curPos = 0;
				curLength = 0;
			} else {
				//If same characters are not found
				prevPos = curPos;
				curLength = 0;
			}
		}
		
		
		if (curLength > 1) {
			str = str.slice(0, prevPos) + str.slice(curPos, str.length);
			result += "->" + str;
		}
		if (str.length == 0) {
			result += " EMPTY";
		}

		if (str == result) {
			result += "No Duplicates Elements";
		}
		else{
			document.getElementById("input").value = "";
		}
		
		
	}
	
	//Display result to user
	document.getElementById("result").innerHTML = result;
}