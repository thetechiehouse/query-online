'use strict';

/* Controllers */

var app = angular.module('queryonline.controllers', []);

// Clear browser cache (in development mode)
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});


app.controller('DummyCtrl', ['$scope', 'DummyFactory', function ($scope, DummyFactory) {
    $scope.bla = 'bla from controller';
    DummyFactory.get({}, function (dummyFactory) {
        $scope.firstname = dummyFactory.firstName;
    })
}]);

app.controller('QueryListCtrl', ['$scope', 'QuerysFactory', 'QueryFactory','QueryEditFactory', '$location',
    function ($scope, QuerysFactory, QueryFactory, QueryEditFactory,  $location) {

 		// callback for ng-click 'selectQuery':
        $scope.selectQuery = function (userId) {
            $location.path('/query-select/' + userId);
        };
        // callback for ng-click 'editQuery':
        $scope.editQuery = function (userId) {
            $location.path('/query-detail/' + userId);
        };

        // callback for ng-click 'deleteQuery':
        $scope.deleteQuery = function (userId) {
        	QueryFactory.deleteQuery({ id: userId }, function(data) {
				$location.path('/query-list');
				$scope.users = QuerysFactory.query();					
				}, function(data) {
				console.log("Error has occured");	
				});
          
        };

        // callback for ng-click 'createQuery':
        $scope.createNewQuery = function () {
            $location.path('/query-creation');
        };
        
        $scope.goToQueryCreation = function () {
            $location.path('/query-creation');
        };
        
        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('/query-list');
        };

        $scope.users = QuerysFactory.query();
    }]);


app.controller('QueryDetailCtrl', ['$scope', '$routeParams', 'QueryEditFactory','QueryUpdateFactory', '$location',
    function ($scope, $routeParams, QueryEditFactory, QueryUpdateFactory, $location) {
        // callback for ng-click 'updateQuery':
	
     $scope.editQuery = function (queryId) {
    	 $scope.user=QueryEditFactory.show({ id: queryId });
         $location.path('/query-detail/' + queryId);
         //$scope.user=userData;
     };
        
     $scope.getExcelData = function (queryId) {
    	alert('saSa111');
    	 // testFactory.sayHello("World");
    	// QueryDownloadDataFactory.getExcelData($scope.user);
         //$scope.user=userData;
     };
        
     
     
        $scope.updateQuery = function () {
        	QueryUpdateFactory.update($scope.user);
           $location.path('/query-list');
        };

        // callback for ng-click 'cancel':
        $scope.cancel = function () {
            $location.path('/query-list');
        };

       $scope.user = QueryEditFactory.show({id: $routeParams.id});
    }]);


app.controller('QueryRunCtrl', ['$scope', '$routeParams', 'QueryEditFactory', 'QueryDownloadDataFactory', '$location',
    function ($scope, $routeParams,QueryEditFactory, QueryDownloadDataFactory, $location) {
        // callback for ng-click 'updateQuery':
     $scope.getExcelData2 = function () {
    	QueryDownloadDataFactory.getExcelData2($scope.user);

     };
     
     $scope.getExcelData3 = function (queryId) {
     	QueryDownloadDataFactory.getExcelData($scope.user);

      };
  // 	alert('333333444');

       $scope.user = QueryEditFactory.show({id: $routeParams.id});
    }]);


app.controller('QueryCreationCtrl', ['$scope', 'QueriesCreateFactory', '$location',
    function ($scope, QueriesCreateFactory, $location) {
        // callback for ng-click 'createNewQuery':
        $scope.createNewQuery = function () {
        	QueriesCreateFactory.createNewQuery($scope.user);
            $location.path('/query-list');
        };
        
        $scope.cancel = function () {
            $location.path('/query-list');
        };
    }]);
