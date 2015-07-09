<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yboard for jQuery</title>
<link href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css"	rel="stylesheet">
<link href="resources/bower_components/bootstrap-select/bootstrap-select.min.css"	rel="stylesheet">
<link href="resources/bower_components/bootstrapValidator/dist/css/bootstrapValidator.min.css" rel="stylesheet">

<script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
<script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="resources/bower_components/bootstrap-select/bootstrap-select.min.js"></script>
<script src="resources/bower_components/bootstrap-paginator/build/bootstrap-paginator.min.js"></script>
<script src="resources/bower_components/bootstrapValidator/dist/js/bootstrapValidator.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<h1>
				Yboard <small>for jQuery</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">Search Box</div>
					<div class="panel-body">
						<div class="form-inline">
							<div class="row">
								<div class="col-md-10">
									<select id="searchColumn" class="selectpicker">
										<option value="boardTitle">제목</option>
										<option value="userName">작성자</option>
									</select> <input type="text" id="searchText" class="form-control">
									<button class="btn btn-default" id="searchBtn">검색</button>
								</div>
								<div class="col-md-2" style="text-align: right">
									<button class="btn btn-primary" data-toggle="modal"
										data-target="#yboardEditModal">등록</button>
									<button class="btn btn-danger" id="btnYboardDelete">삭제</button>
								</div>
							</div>
						</div>
					</div>
					<!-- Table -->
					<table class="table table-striped" id="dataTable">
						<thead>
							<tr>
								<th><input type="checkbox" id="allCheck"/></th>
								<th>ID</th>
								<th>제목</th>
								<th>우선순위</th>
								<th>작성자</th>
								<th>성별</th>
								<th>날짜</th>
							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
			<!-- 페이징처리 부분  -->
			<div class="col-md-8">
				<ul class="pagination" id="yboardPagination">
				</ul>
			</div>
		</div>
	</div>


	<!-- Modal : Yboard Edit -->
	<div class="modal fade" id="yboardEditModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Yboard 등록/수정</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" id="yboardForm">
						<input type="hidden" id="yboard_boardIDEncrypt" name="boardIDEncrypt">
						<div class="form-group">
							<label for="yboard_boardTitle" class="col-sm-2 control-label">제목</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="yboard_boardTitle"
									name="boardTitle" placeholder="제목을 입력하세요">
							</div>
						</div>
						<div class="form-group">
							<label for="yboard_priority" class="col-sm-2 control-label">우선순위</label>
							<div class="col-sm-10">
								<select id="yboard_priority" class="selectpicker">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="yboard_userName" class="col-sm-2 control-label">작성자명</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="yboard_userName"
									name="userName" placeholder="작성자명을 입력하세요">
							</div>
						</div>
						<div class="form-group">
							<label for="yboard_genderM" class="col-sm-2 control-label">성별</label>
							<div class="col-sm-10">
								<label class="radio-inline"> <input type="radio"
									id="yboard_genderM" name="userGender" value="M">남성
								</label> <label class="radio-inline"> <input type="radio"
									id="yboard_genderF" name="userGender" value="F">여성
								</label>
							</div>
						</div>
						<div class="form-group">
							<label for="yboard_boardContent" class="col-sm-2 control-label">내용</label>
							<div class="col-sm-10">
								<textarea style="height: 200px; width: 100%;"
									id="yboard_boardContent" name="boardContent"></textarea>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary" id="btnYboardSave">저장</button>
				</div>
			</div>
		</div>
	</div>


</body>
<script src="resources/js/jquery/yboard.js"></script>
</html>