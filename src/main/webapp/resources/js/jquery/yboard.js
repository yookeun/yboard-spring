
/**
 * yboard 리스트 출력 
 * @param start
 * @param limit
 */
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
			alert("Loading failed!");
		},
		success: function(returnJSON) {
			if (returnJSON.success) {
				$.each(returnJSON.items, function(i, yboard) {
					records += "<tr>" 
						  				+ "<td><input type='checkbox'/></td>"
						  				+ "<td>" + yboard.boardID + "</td>"
						  				+ "<td>" + yboard.boardTitle +"</td>" 
						  				+ "<td>" + yboard.priority +"</td>" 
						  				+ "<td>" + yboard.userName +"</td>" 
						  				+ "<td>" + yboard.userGender +"</td>" 
						  				+ "<td>" + yboard.registDate +"</td>"
						  				+ "</tr>"
				});
				$('#dataTable > tbody').html(records);
			} else {
				alert("Loading failed!");
			}
		}
	});

};


//초기화 
(function(){
	showList(0,10);
})();