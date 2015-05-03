'use strict';

/* Services */

/*
 http://docs.angularjs.org/api/ngResource.$resource

 Default ngResources are defined as

 'get':    {method:'GET'},
 'save':   {method:'POST'},
 'query':  {method:'GET', isArray:true},
 'remove': {method:'DELETE'},
 'delete': {method:'DELETE'}

 */

var services = angular.module('queryonline.services', ['ngResource']);

services.factory('DummyFactory', function ($resource) {
    return $resource('/queryonline/dummy', {}, {
        query: { method: 'GET', params: {}, isArray: false }
    })
});

services.factory('QuerysFactory', function ($resource) {
    return $resource('/api/queryonline/allQueries', {}, {
        query: { method: 'GET', isArray: true }
    })
});



services.factory('QueryEditFactory', function ($resource) {
    return $resource('/api/queryonline/query/:id', {}, {
        show: { method: 'GET' },
        update: { method: 'PUT', params: {id: '@id'} }
    });
});


services.factory('QueryUpdateFactory', function ($resource) {
    return $resource('/api/queryonline/updateQuery', {}, {
        update: { method: 'PUT', params: {id: '@id'} }
        
    });
});



//Factory
services.factory('QueryDownloadDataFactory', function($http){
    return {
    	getExcelData: function(){
    	    window.open('/api/queryonline/export.xslx', '_blank', '');  
/*
    		$http({
    		    url: '/api/queryonline/export.xslx',
    		    method: "GET",
    		    data: json, //this is your json data string
    		    headers: {
    		       'Content-type': 'application/json'
    		    },
    		    responseType: 'arraybuffer'
    		}).success(function (data, status, headers, config) {
    		    var blob = new Blob([data], {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"});
    		    var objectUrl = URL.createObjectURL(blob);
    		    window.open(objectUrl);
    		}).error(function (data, status, headers, config) {
    		    //upload failed
    		});
    		*/
    		
    		// Simple GET request example :
    	/*	$http.get('/api/queryonline/export.xslx').
    		  success(function(data, status, headers, config) {
    			 // window.open(data);
    			  var blob = new Blob([data], {type: "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8"});
    		        //saveAs(blob, "Report14");

      		    var objectUrl = URL.createObjectURL(blob);
      		    window.open(objectUrl);
      		    }).
    		  error(function(data, status, headers, config) {
    			  alert('error occured') ;   	
    			  	// or server returns response with an error status.
    		  });
    		*/
  }  
    }               
});



services.factory('QueryFactory', function ($resource) {
    return $resource('/api/queryonline/deleteQuery', {}, {
        deleteQuery: { method: 'DELETE', params: {id: '@id'}},
        	show: { method: 'GET'}
    });
});
/*
services.factory('QueryFactory', function ($resource) {
    return $resource('/queryonline/deletePerson/:id', {}, {
        deleteQuery: { method: 'DELETE', params: {id: '@id'}},
        	show: { method: 'GET', params: {id: '@id'}}
    });
});
*/


services.factory('QueriesCreateFactory', function ($resource) {
    return $resource('/api/queryonline/addQuery', {}, {
    	createNewQuery: { method: 'POST' }
    })
});
