var app = angular.module('app', []);

app.controller('MainCtrl', ['$scope', '$http', '$log', '$timeout','$window', function ($scope, $http, $log, $timeout,$window) {

      $http({
        method: 'GET',
        url: 'http://10.10.0.72:8080/queue/all'
     }).then(function (response){
      $scope.queueList = response.data;
      $scope.Length=response.data.Length;  
     },function (error){
  
     });
     $scope.postdata = function( qname, maximumsize){
     var data = {qid:'1', qname:qname, maximumsize:maximumsize, lastModifiedDate:null,createdDate:null};
     
     $http.post('http://10.10.0.72:8080/queue/add', JSON.stringify(data)).then(function (response) {

      if (response.data)
      
      $scope.msg = "Post Data Submitted Successfully!";
      console.log($scope.msg);
      $window.location.reload();
    })
    
  };
  $scope.edit = function(queue){
    $scope.qid= queue.qid;
    $scope.qname= queue.qname;
    $scope.maximumsize= queue.maximumsize;
    

  
  }
}]);
