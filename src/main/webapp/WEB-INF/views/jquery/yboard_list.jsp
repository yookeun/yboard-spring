<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yboard for jQuery</title>
<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
<script src="resources/js/jquery.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<h1>
				Yboard <small>for jQuery</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default">
					<!-- Default panel contents -->
					<div class="panel-heading">Search Box</div>
					<div class="panel-body">
						<div class="col-md-6">
							<div class="input-group">
								<input type="text" class="form-control"> <span
									class="input-group-btn">
									<button class="btn btn-default" type="button">Search!</button>
								</span>
							</div>
						</div>
						<div class="col-md-2">
							<button type="button" class="btn btn-primary">Add</button>
							<button type="button" class="btn btn-danger">Delete</button>
						</div>
					</div>
					<!-- Table -->
					<table class="table table-striped" id="dataTable">
						<thead>
							<tr>
								<th><input type="checkbox"/></th>
								<th>ID</th>
								<th>TITLE</th>
								<th>PRIORITY</th>
								<th>USERNAME</th>
								<th>GENDER</th>
								<th>DATE</th>
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
<!-- 페이징처리를 위한 플러그인  -->
<script src="resources/js/plugins/bootstrap-paginator.js"></script>
<script src="resources/js/jquery/yboard.js"></script>
</html>