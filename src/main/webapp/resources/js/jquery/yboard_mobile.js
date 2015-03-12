
/**
 * yboard 리스트 출력 
 * @param start
 * @param limit
 */
function showList(search) {
	var records = "";
	if (search === null) {
		var search = {
			start: 0,
			page: 1
		};
	}
	search.limit = 10;
	search.searchColumn= $('#searchColumn').val();
	search.searchText = $('#searchText').val();
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
				if (returnJSON.total  > 0) {
					$.each(returnJSON.items, function(i, yboard) {				
						records += '<li><a href="#page2" onclick="javascript:viewYboard(\''+yboard.boardIDEncrypt+'\')">'+yboard.boardTitle+'</a></li>';
					});
				} else {
					records = '<li>데이터가 존재하지 않습니다.</li>';
				}
			
				//html에 입력후 refresh해준다. 
				$('#dataUL').html(records);
				$('#dataUL').listview().listview("refresh");  //jQuery Mobile listview needs to be initialized before refresh can be triggered:
				$('#page').val(search.page);	//현재페이지를 저장한다.
				mobileShowPagingButton(returnJSON.total , search.limit , search.page);
						
			} else {
				alert("Loading failed!");
			}
		}
	});
};


$(document).ajaxStart(function() {
	$.mobile.loading('show');
});

// ajaxStop is totally ignored by changePage() so pointless...
$(document).ajaxStop(function() {
	$.mobile.loading('hide');
});

/**
 * 페이징버튼 보이기
 * 
 * @param total
 * @param limit
 * @param pageNo
 */
function mobileShowPagingButton(total, limit, pageNo)  {	
	 //전체페이지를 계산한다.
	 var totalPage = Math.ceil(total / limit);
	 var nowPage = Number($('#page').val());
		 
	 //전체페이지가 1페이지밖에 없다면
	  if (total ===0 || totalPage === 1) {
		 	$('#previousPage').addClass('ui-state-disabled'); // previousPage 버튼 -  비활성화
			$('#nextPage').addClass('ui-state-disabled'); //nextPage 버튼 -  활성화
	 }	
	 
	 //전체페이지가 2이상이고, 현재 페이지가 1페이지 라면 
	 else if (totalPage > 1 && nowPage === 1) {
		 	$('#previousPage').addClass('ui-state-disabled'); // previousPage 버튼 -  비활성화
			$('#nextPage').removeClass('ui-state-disabled'); //nextPage 버튼 -  활성화
	 }
	
	 //전체페이지가 2이상이고, 현재 페이지가 전체페이지를 넘지 않는다면  
	 else if (totalPage > 1 && nowPage <  totalPage) {
		 	$('#previousPage').removeClass('ui-state-disabled');
			$('#nextPage').removeClass('ui-state-disabled');
	
	 }	 
	 //마지막페이지라면 
	 else if (totalPage > 1 && nowPage >=  totalPage) {
		 	$('#previousPage').removeClass('ui-state-disabled');
			$('#nextPage').addClass('ui-state-disabled');
	
	 }
}


/**
 * 페이지이동 
 * @param num
 */
function moveMobilePaging(num) {
	var start = 0;
	var limit = 10;
	var page = 1;	
	page = Number($('#page').val()) + (Number(num));	
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

/**
 * 이전페이지 
 */
$('#previousPage').click(function() {	
	moveMobilePaging(-1);
})


/**
 * 다음페이지 
 */
$('#nextPage').click(function() {
	moveMobilePaging(1);
})


/**
 * 공지내용 보기 
 * @param boardIDEncrypt
 */
function viewYboard(boardIDEncrypt) {
	$.ajax({
		type: "GET",
		dataType: "JSON",
		contentType: "application/json; charset=UTF-8",
		url: "/yboard/view/"+boardIDEncrypt,
		error: function() {
			alert("Loading failed!");
		},
		success: function(returnJSON) {
			if (returnJSON.success) {
				var yboard = returnJSON.data;
				$('#boardTitle').html(yboard.boardTitle);
				$('#boardContent').html(yboard.boardContent);			
			} else {
				alert("Loading failed!");
			}
		}
	});
}

/**
 * 새로고침 버튼 클릭 
 */
$('#menuRefresh').click(function() {
	location.reload();
});

/**
 * 브라우저 새로고침 
 */
function yboardReload() {
	location.href="#page1";
}


/**
 * 게시판 메뉴 선택시 
 */
$('#board').click(function(){
	$('#help_content').hide();
	$('#board_content').show();
});

/**
 * 도움말 메뉴 선택시 
 */
$('#help').click(function(){
	$('#help_content').show();
	$('#board_content').hide();
});

// 초기화
(function(){
	showList(null);  //0부터 1페이지를 출력 
	$('#help_content').hide();
})();