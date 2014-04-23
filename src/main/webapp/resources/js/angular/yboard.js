function yboardList($scope, $http) {
	var yboard = {
			start: 0, 
			limit:10
	}
	/*
	$http.post('/yboard/select', yboard).
		success(function(returnJSON) {
			$scope.yboards = returnJSON.items;
		});
		*/
	console.log(JSON.stringify(yboard));
	$http({
		url: '/yboard/select',
		method: 'POST',
		data: JSON.stringify(yboard),
		headers: {'Content-Type': 'application/json'}
	});
}