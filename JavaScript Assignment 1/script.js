

document.getElementById('home').addEventListener("click",function(event){
	location.href = "home.html";
});

document.getElementById('contactus').addEventListener("click",function(event){
	location.href = "contactus.html";
});


function validateName(){
	var x;
	document.getElementById("name").maxLength="20";
	if ((x=document.forms['myForm']['name'].value )== ""){
		document.getElementById("name-warning").value="Empty : Write Something";
		document.forms['myForm']['name'].style.border="2px solid red";
		document.getElementById("name-warning").style.visibility="visible";
		return false;
	}
	else if( !x.match( /^[a-zA-z]+$/)){
		document.getElementById("name-warning").value="Only Characters Allowed";
		document.forms['myForm']['name'].style.border="2px solid red";
		document.getElementById("name-warning").style.visibility="visible";
		return false;
	
	}
	else{
	document.forms['myForm']['name'].style.border="2px solid green";
	document.getElementById("name-warning").style.visibility="hidden";
	return true;
	}

}

function validateEmail(){
	var x;	
	 if( (x=document.forms['myForm']['email'].value )== ""){
	 	document.getElementById("email-warning").value="Empty : Write Something";
		document.forms['myForm']['email'].style.border="2px solid red";
		document.getElementById("email-warning").style.visibility="visible";
		return false;
	}
	else if(!x.match(/[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$/)){
		document.getElementById("email-warning").value="Enter Valid Email Address";
		document.forms['myForm']['email'].style.border="2px solid red";
		document.getElementById("email-warning").style.visibility="visible";
		return false;
	}
	else{
	document.forms['myForm']['email'].style.border="2px solid green";
	document.getElementById("email-warning").style.visibility="hidden";
	return true;

	}
}

function validateOrganization(){
	var x;
	
	if ((x=document.forms['myForm']['organization'].value )== ""){
		document.getElementById("organization-warning").value="Empty : Write Something";
		document.forms['myForm']['organization'].style.border="2px solid red";
		document.getElementById("organization-warning").style.visibility="visible";
		return false;
	}
	else if( !x.match( /^[a-zA-z]+$/) ){
		document.getElementById("organization-warning").value="Only Characters Allowed";
		document.forms['myForm']['organization'].style.border="2px solid red";
		document.getElementById("organization-warning").style.visibility="visible";
		return false;
	
	}
	else{
	document.forms['myForm']['organization'].style.border="2px solid green";
	document.getElementById("organization-warning").style.visibility="hidden";
	return true;
	}
}

function validatePhoneNumber(){
	var x;
	 if( (x=document.forms['myForm']['contactnumber'].value )== "" ){
	 	document.getElementById("phone-warning").value="Empty : Write Something";
		document.forms['myForm']['contactnumber'].style.border="2px solid red";
		document.getElementById("phone-warning").style.visibility="visible";
		return false;
	}
	else if( !x.match(/^[0-9]{6,12}$/) ){
		document.getElementById("phone-warning").value="Only 6-12 digit number allowed";
		document.forms['myForm']['contactnumber'].style.border="2px solid red";
		document.getElementById("phone-warning").style.visibility="visible";

	}
	else{
		document.forms['myForm']['contactnumber'].style.border="2px solid green";
		document.getElementById("phone-warning").style.visibility="hidden";
	return true;

	}	


}

function validateTextArea(){

	document.getElementById("message").maxLength="250";

	 if(document.getElementById("message").value== ""){
	 	document.getElementById("text-warning").value="Empty : Write Something";
	 	document.getElementById("text-warning").style.visibility="visible";
		document.getElementById("message").style.border="2px solid red";
		return false;
	}
	else{
		document.getElementById("message").style.border="2px solid green";
		document.getElementById("text-warning").style.visibility="hidden";
	return true;

	}	


}
function validateForm(){


if(!validateName() || !validateEmail() || !validateOrganization() || !validateTextArea() || !validatePhoneNumber()){
	validateName();
	validateEmail();
	validateOrganization();
	validatePhoneNumber();
	validateTextArea();
	cityOption();
	return false;
}
return true;
}

function cityOption(){

	document.getElementById("selectedcity").style.visibility="visible";
	var element = document.getElementById("select");
	var selectedValue =element.options[element.selectedIndex].value;

	if(selectedValue == "default"){
		document.getElementById("select").style.border="2px solid red";
		document.getElementById("selectedcity").value="No option choosed";
	}
	else{
		document.getElementById("select").style.border="2px solid green";
	document.getElementById("selectedcity").value="You have selected :"+selectedValue;
	}
}




