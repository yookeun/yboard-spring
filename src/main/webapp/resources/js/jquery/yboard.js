
/**
 * yboard 리스트 출력 
 * @param start
 * @param limit
 */
function showList(search) {
	var records = "";
	search.limit = 10;
	$.ajax({
		type: 'POST',		
		dataType: 'JSON',
		data:  JSON.stringify(search),
	    contentType:"application/json; charset=UTF-8",
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
				//페이징표시 
				if (returnJSON.total > 0 ) {
					goPagination(returnJSON.total, 10, search.page);
				}
				
			} else {
				alert("Loading failed!");
			}
		}
	});
};


/**
 * 페이징 처리 
 * @param total
 * @param limit
 * @param page_index
 * 
 */
function goPagination(total, limit, page_index) {		
	// http://bootstrappaginator.org/ 참고할 것!
	var options = {
		bootstrapMajorVersion : 3,
		currentPage : page_index,
		totalPages : Math.ceil(total / limit),
		numberOfPages : 10,
		onPageClicked : function(e, originalEvent, type, page) {
			var start = 0;
			// 1페이지라면
			if (page === 1) {
				start = 0;
			} else if ( page > 1){
				// 2페이지이상이면 10 ~ limit 건씩, 3페이지라면 20~limit 건씩 출력
				start = (page - 1) * limit;
			}
			var search = {
					start: start,
					page: page
			};
			showList(search);	//리스트를 새로 조회한다. 
		}
	}
	$('#yboardPagination').bootstrapPaginator(options);
}
            

// 초기화
(function(){
	var search = {
			start: 0,
			page: 1,
	};
	showList(search);  //0부터 1페이지를 출력 
})();