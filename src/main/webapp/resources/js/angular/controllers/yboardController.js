angular.module("yboard",["brantwills.paging"]).controller("yboardCtrl", function($scope, $http) {
	var  yboard = {
			start : 0,
			limit : 10
	}
	$http ({
		url : '/yboard/select',
		method : 'POST',
		data: yboard
	}).success(function(returnJSON) {
		$scope.yboardList = returnJSON.items;
		$scope.totalCount = returnJSON.total;
	    $scope.DoCtrlPagingAct = function(text, page, pageSize, total){
	        //console.log({text, page, pageSize, total});
	    };	
	})	
});