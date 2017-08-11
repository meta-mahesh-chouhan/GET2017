setInterval(function() {
	var d = new Date();
	
	//Return current time as message
	postMessage(d.getHours() + ":" + d.getMinutes() + ":" + d.getSeconds());
}, 1000);
