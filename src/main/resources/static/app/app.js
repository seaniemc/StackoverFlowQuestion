
var todoApp = angular.module('todoApp', [
    'ui.router',
    'jcs-autoValidate',
	'angular-ladda'
]);

todoApp.config(function ($stateProvider, $urlRouterProvider) {
    var homeState = {
        name: 'home',
        url: '/',
        templateUrl: 'app/views/todo.html',
        controller: 'TodoController'
    };

    var loginState = {
        name: 'login',
        url: '/login',
        templateUrl: 'app/views/login.html',
        controller: 'UserController'
    };
     var registerState = {
        name: 'register',
        url: '/register',
        templateUrl: 'app/views/register.html',
        controller: 'UserController'
    };

    $stateProvider
        .state(homeState)
        .state(registerState)
         .state(loginState);

    $urlRouterProvider.otherwise('/');
});