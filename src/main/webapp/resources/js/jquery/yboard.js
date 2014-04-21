

function showList(start, limit) {
	var records = "";
	var search = {
			start: start,
			limit: limit
	};	
	$.ajax({
		type: 'POST',
		dataType: 'JSON',
		data: search,
		url: '/yboard/select',
		error: function() {
			
		},
		success: function(returnJSON) {
			if (returnJSON.success) {
				$.each(returnJSON.items, function(i, yboard) {
					records += "<tr><td>" + yboard.boardID + "</td>"
									  + "<td>" + yboard.boardTitle +"</td>" 
									  + "<td>" + yboard.priority +"</td>" 
									  + "<td>" + yboard.userName +"</td>" 
									  + "<td>" + yboard.gender +"</td></tr>"
				});
				$('#dataTable > tbody').html(records);
			} else {
				alert("Fail!!!!");
			}
		}
	});

};


//초기화 
(function(){
	showList(0,0);
})();