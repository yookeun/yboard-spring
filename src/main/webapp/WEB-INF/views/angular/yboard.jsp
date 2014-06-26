<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Yboard for AngularJS</title>
<link href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="resources/bower_components/angular/angular.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="page-header">
			<h1>
				Yboard <small>for AngularJS</small>
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
						<div class="col-md-3">
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
						<tbody ng-controller="yboardList">
							<tr ng-repeat="yboard in yboards">
								<td><input type="checkbox"/></td>
								<td>{{yboard.boardID}}</td>
								<td>{{yboard.boardTitle}}</td>
								<td>{{yboard.priority}}</td>
								<td>{{yboard.userName}}</td>
								<td>{{yboard.userGender}}</td>
								<td>{{yboard.registDate}}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>			
			<div class="col-md-8">				
				<ul class="pagination">
					<li><a href="#">&laquo;</a></li>
					<li><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
			</div>
		</div>
	</div>
</body>
<script src="resources/js/angular/yboard.js"></script>
</html>