'use strict';

// Declare app level module which depends on filters, and services
angular.module('ngdemo', ['queryonline.filters', 'queryonline.services', 'queryonline.directives', 'queryonline.controllers']).
    config(['$routeProvider', function ($routeProvider) {

        $routeProvider.when('/query-list', {templateUrl: 'partials/query-list.html', controller: 'QueryListCtrl'});
        $routeProvider.when('/query-select/:id', {templateUrl: 'partials/query-select.html', controller: 'QueryRunCtrl'});
        $routeProvider.when('/query-detail/:id', {templateUrl: 'partials/query-detail.html', controller: 'QueryDetailCtrl'});
        $routeProvider.when('/query-creation', {templateUrl: 'partials/query-creation.html', controller: 'QueryCreationCtrl'});
        $routeProvider.otherwise({redirectTo: '/query-list'});
    }]);
