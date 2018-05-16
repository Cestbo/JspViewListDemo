/**
 * 
 */

function search() {
	var input = document.getElementById("searchText").value
	$.post("SearchServlet", {
		"input" : input
	}, function(data, status) {
		var searchTip = document.getElementById("searchTip");
		searchTip.style.display = "block";
		var list = data.split(",");
		for (var i = 0; i < list.length-1; i++) {
			searchTip.
			innerHTML = list[i]+"<br>"
					;
		}
	})
}