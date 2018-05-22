/**
 * 
 */


function search() {
	var input = document.getElementById("searchText").value
	$.post("SearchServlet", {
		"input" : input
	}, function(data, status) {
		
		var list = data.split(",");
		$("#searchTip").html("");
		searchTip.style.display = "block";
		for (var i = 0; i < list.length-1; i=i+2) {
			
			var textTip="";
			textTip= "<span id=item"+list[i+1]+">"+list[i]+"</span><br>"
					;
			$("#searchTip").append(textTip);
			var id=list[i+1];
			$("#item"+id).mouseover(function(){
				$(this).css("background","gray");
			})
			$("#item"+id).mouseout(function(){
				$(this).css("background","white");
			})
			$("#item"+id).bind("click",function(event){
				var a=this.id;
				var b=a.slice(4);
				window.location.href="details.jsp?id="+b;
				
			})
				
			
		}
		
		
	})
}