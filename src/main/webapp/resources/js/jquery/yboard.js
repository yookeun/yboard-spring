
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
				$.each(returnJSON.items, function(i, yboard) {
					records += '<tr>' 
						  				+ '<td><input type="checkbox" name="yboardIDs" value="'+yboard.boardIDEncrypt+'"/></td>'
						  				+ '<td>' + yboard.boardID + '</td>'
						  				+ '<td><a href="#" onclick="viewYboard(\''+yboard.boardIDEncrypt+'\')">' + yboard.boardTitle +'</a></td>' 
						  				+ '<td>' + yboard.priority +'</td>'
						  				+ '<td>' + yboard.userName +'</td>' 
						  				+ '<td>' + yboard.userGender +'</td>' 
						  				+ '<td>' + yboard.registDate +'</td>'
						  				+ '</tr>'
				});
				$('#dataTable > tbody').html(records);
				//페이징표시 
				if (returnJSON.total > 0 ) {
					goPagination(returnJSON.total, 10, search.page);
					$('#yboardPagination').show();
				} else {
					$('#yboardPagination').hide();
				}
				
			} else {
				alert("Loading failed!");
			}
		}
	});
};

/**
 * 검색버튼 클릭시
 */
$('#searchBtn').click(function() {
	showList(null);
});


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
				$('#yboard_boardIDEncrypt').val(yboard.boardIDEncrypt);
				$('#yboard_boardTitle').val(yboard.boardTitle);
				$('#yboard_priority > option[value="'+yboard.priority+'"]').prop('selected',true);
				$('#yboard_priority').selectpicker('render');
				$('#yboard_userName').val(yboard.userName);
				$(':radio[name="userGender"]').filter('[value="'+yboard.userGender+'"]').prop("checked", true);
				$('#yboard_boardContent').text(yboard.boardContent);
				$('#yboardEditModal').modal('show');
			} else {
				alert("Loading failed!");
			}
		}
	});
}

/**
 * 페이징 처리 
 * @param total
 * @param limit
 * @param page_index
 * 
 */
function goPagination(total, limit, page_index) {
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


function formValidator() {	
	$('#yboardForm').bootstrapValidator({
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},		
		fields : {
			boardTitle : {
				validators : {
					notEmpty : {
						message : '제목은 필수입력입니다.'
					},
					stringLength : {
						min : 2,
						max : 30,
						message : '최소 2자에서 30자이내로 입력하세요'
					}
				}
			},
			userName : {
				validators : {
					notEmpty : {
						message : '작성자명은 필수입력입니다.'
					},
					stringLength : {
						min : 2,
						max : 30,
						message : '최소 2자에서 10자이내로 입력하세요'
					}
				}
			},			
			userGender: {
				validators: {
					notEmpty: {
						message: "성별은 필수선택입니다."
					}
				}
			},
			boardContent: {
				validators : {
					notEmpty : {
						message : '내용은 필수입력입니다.'
					},
					stringLength : {
						min : 2,
						message : '최소 2자 이상은 입력하세요'
					}
				}				
			}
		}  // } fields 
		
	}).bootstrapValidator('validate');
	return $('#yboardForm').data('bootstrapValidator').isValid();
};

/**
 * 폼을 리셋한다.
 * @param formID
 */
function resetForm(formID) {
	$("#" + formID).each(function() {
		this.reset();
	});
	$('#yboard_boardIDEncrypt').val('')
	var bootstrapValidator = $('#'+formID).data('bootstrapValidator');
	if (bootstrapValidator != null) {
		bootstrapValidator.resetForm();
	}
}

/**
 * 모달창이 닫힐때 폼내용을 reset해준다.
 */
$('.modal').on('hidden.bs.modal', function(){
	$('#yboard_boardContent').text('');
	resetForm('yboardForm');
});

/**
 * 저장 
 */
$('#btnYboardSave').click(function() {
	var boardIDEncrypts = $('#yboard_boardIDEncrypt').val();
	var method = "insert";
	if (boardIDEncrypts != "") {
		method = "update";
	}
	//폼입력값 검증
	if(!formValidator()) {
		return;
	}	
	
	//var surveyCode = $("#surveyCodeForm" ).serializeObject();
	var yboard = {
		boardTitle: $('#yboard_boardTitle').val(),
		priority: $('#yboard_priority').val(),
		userName: $('#yboard_userName').val(),
		userGender: $('input[type="radio"]:checked').val(),
		boardContent: $('#yboard_boardContent').val(),
		boardIDEncrypt: boardIDEncrypts
	};
	
	$.ajax({
		type: "POST",
		dataType: "JSON",
		data: JSON.stringify(yboard),
		contentType : "application/json; charset=UTF-8",
		url: '/yboard/'+method,
		error: function() {
			alert("Loading failed!");
		},
		success: function(returnJSON) {
			if (returnJSON.success) {
				showList(null);
				resetForm('yboardForm');
				
				$('#yboardEditModal').modal('hide');
			} else {
				alert(returnJSON.msg);
			}
		}
	});
	
});


/**
 * 체크된 게시내용 삭제 
 */
$('#btnYboardDelete').click(function(){
	var checkedYboardIDs = $(':checkbox[name="yboardIDs"]').map(function(){
		if(this.checked) {
			return this.value;
		}
	}).get().join(",");
	
	//아무것도 체크되어 있지 않다면 에러표시 
	if (checkedYboardIDs ==="") {
		alert("한개 이상 체크되어야 합니다.");
		return;
	}

	var param = {
			boardIDs: checkedYboardIDs
	};
	$.ajax({
		type: "POST",
		dataType: "JSON",
		data: JSON.stringify(param),
		contentType: "application/json; charset=UTF-8",
		url: "/yboard/delete",
		error: function() {
			alert("Loading failed!")
		},
		success: function(returnJSON) {
			if(returnJSON.success) {
				showList(null);
			} else {
				alert("Deleting failed!")
			}
		}
	});
});

           
/**
 * 일괄체크-해제
 */
$('#allCheck').click(function() {
	if(this.checked) {
		$(':checkbox[name="yboardIDs"]').prop("checked", true);
	} else {
		$(':checkbox[name="yboardIDs"]').prop("checked", false);
	}
});

// 초기화
(function(){
	$('.selectpicker').selectpicker({
		width: "auto"
	});
	showList(null);  //0부터 1페이지를 출력 
})();