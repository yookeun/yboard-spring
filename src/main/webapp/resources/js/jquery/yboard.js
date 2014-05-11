
/**
 * yboard 리스트 출력 
 * @param start
 * @param limit
 */
function showList(start, page) {
	var records = "";
	var search = {
			start: start,
			limit: 10,
			searchColumn: $('#yboard_searchColumn').val(),
			searchText: $('#yboard_searchText').val()
	};	
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
			} else {
				alert("Loading failed!");
			}			
			//페이징처리함수 호출 
			if (returnJSON.total > 0) {
				goPagination(returnJSON.total, 10, page);
			} else {
				//$('#yboardPagination').hide();
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
	console.log(total);
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
			showList(start, page);	//리스트를 새로 조회한다. 
		}
	}
	$('#yboardPagination').bootstrapPaginator(options);
};


/**
 * 검색 클릭 
 */
$('#yboard_search').click(function() {
	showList(0,1);
});
            

// 초기화
(function(){
	showList(0,1);  //0부터 1페이지를 출력 
})();