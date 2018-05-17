/**
 * 
 */

function search() {
	var input = document.getElementById("searchText").value
	$.post("SearchServlet", {
		"input" : input
	}, function(data, status) {
		var searchTip = document.getElementById("searchTip");
		
		var list = data.split(",");
		var textTip="";
		for (var i = 0; i < list.length-1; i++) {
			
			textTip+= list[i]+"<br>"
					;
		}
		searchTip.innerHTML=textTip;
		searchTip.style.display = "block";
	})
}