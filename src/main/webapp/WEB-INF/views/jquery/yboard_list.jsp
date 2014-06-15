<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yboard for jQuery</title>
<link href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/bower_components/bootstrap-select/bootstrap-select.min.css" rel="stylesheet">

<script src="resources/bower_components/jquery/dist/jquery.min.js"></script>
<script src="resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="resources/bower_components/bootstrap-select/bootstrap-select.min.js"></script>
<!-- 페이징처리를 위한 플러그인  -->
<script src="resources/js/plugins/jquery.twbsPagination.min.js"></script>

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
									</select>
									<input type="text" id="searchText" class="form-control">
									<button class="btn btn-default" id="searchBtn">검색</button>
								</div>
								<div class="col-md-2" style="text-align: right">
									<button class="btn btn-primary">등록</button>
									<button class="btn btn-danger">삭제</button>
								</div>
							</div>
						</div>
					</div>
					<!-- Table -->
					<table class="table table-striped" id="dataTable">
						<thead>
							<tr>
								<th><input type="checkbox" /></th>
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
</body>
<script src="resources/js/jquery/yboard.js"></script>
</html>