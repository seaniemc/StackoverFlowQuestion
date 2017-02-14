todoApp.controller('UserController', ['Users','$scope', function UserController(Users, $scope) {
    console.log("in user controller");

    $scope.formModel = {};
	$scope.submitting = false;
	$scope.submitted = false;
	$scope.has_error = false;

	Users.get()
    .success(function(data) {
        $scope.users = data;
    });

	$scope.createUser = function() {
        if(!$scope.userForm.$valid) {
            return;
        }
		Users.create($scope.formModel)
		.success(function(data){
			
			$scope.submitting = false;
			$scope.submitted = true;
			$scope.has_error = false;
            $scope.formModel = {}; // clear the form so our user is ready to enter another
            $scope.users.push(data);
            console.log(":)");
		}).error(function(data) {
			console.log(":(");
			$scope.submitting = false;
 			$scope.submitted = false;
 			$scope.has_error = true;
		});
	
    };

}]);