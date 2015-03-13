<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>Yboard for jQuery Mobile</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="resources/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.css"	rel="stylesheet">
<script src="resources/bower_components/jquery/jquery.min.js"></script>
<script src="resources/js/jquery.mobile-1.4.5/jquery.mobile-1.4.5.min.js"></script>

</head>
<body onload="yboardReload()">
	<!-- 게사판 리스트 페이지  -->
	<div data-role="page" id="page1">
		<div data-role="header" data-theme="b"  data-position="fixed">
			<a href="javascript:void(0)" class="ui-btn-b ui-btn-left ui-btn ui-btn-inline ui-mini ui-corner-all ui-btn-icon-left ui-icon-refresh" id="menuRefresh">새로고침</a>
			<h1>Yboard for JQuery Mobile</h1>
			<a href="#" class="ui-btn-b ui-btn-right ui-btn ui-btn-inline ui-mini ui-corner-all ui-btn-icon-right ui-icon-power">로그아웃</a>
			<nav data-role="navbar">
				<a href="#" class="ui-btn-active" id="board">게시판</a>
				<a href="#" id="help">도움말</a>
			</nav>
		</div>
		<div role="main" class="ui-content" id="board_content"'>		
			<form action="javascript:showList(null)">
				<div>					
					<input type="hidden" id="searchColumn" value="boardTitle"> 
					<input type="search" id="searchText" value="" placeholder="Placeholder text...">
				</div>
				<ul data-role="listview" data-inset="true" id="dataUL">
				</ul>
				<div class="ui-grid-a">
					<div class="ui-block-a">
						<a href="#" class="ui-btn ui-shadow ui-corner-all"	id="previousPage"><< Previous</a>
					</div>
					<div class="ui-block-b">
						<a href="#" class="ui-btn ui-shadow ui-corner-all" id="nextPage">Next >>
						</a>
					</div>
				</div>
				<input type="hidden" id="page">
			</form>
		</div>
		
		<div role="main" class="ui-content" id="help_content"'>		
			<h1>Help 페이지</h1>	
		</div>				
				
		<div data-role="footer" data-theme="b" data-position="fixed">			
			<h2>Yboard</h2>
		</div>
	</div>
	<!-- 게시판 리스트에 선택한 내용 페이지 -->
	<div data-role="page" id="page2">
		<div data-role="header" data-theme="a"  data-position="fixed">
			<h1 id="boardTitle"></h1>
		</div>
		<div role="main" class="ui-content" id='main_content"'>					
			<pre id="boardContent"></pre>
		</div>		
			<a href="#page1" class="ui-btn ui-shadow ui-corner-all ui-btn-icon-left ui-icon-back">Back</a>
	</div>
</body>
<script src="resources/js/jquery/yboard_mobile.js"></script>
</html>