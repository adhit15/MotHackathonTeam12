var app = angular.module('app', ['ngTouch', 'ui.grid', 'ui.grid.selection','ui.grid.grouping']);

app.controller('MainCtrl', ['$scope', '$http', '$log', '$timeout', 'uiGridConstants', 'uiGridGroupingConstants','$interval', function ($scope, $http, $log, $timeout, uiGridConstants, uiGridGroupingConstants,$interval) {
  $scope.gridOptions = {
    enableRowSelection: true,
    enableSelectAll: true,
    selectionRowHeaderWidth: 35,
    enableGroupHeaderSelection: false,
    rowHeight: 35,
    showGridFooter:true,
    enableColumnResizing: true
  };

  $scope.gridOptions.columnDefs = [
    { name: 'id', width:'10%', displayName:'QueueId'},
    { name: 'name', displayName:'QueueName' }
  ];

  $scope.gridOptions.multiSelect = true;

  // $http.get('http://10.10.0.73:8080/getQueaus')
  //   .success(function(data) {
  //     $scope.gridOptions.data = data;
  //     $timeout(function() {
  //       if($scope.gridApi.selection.selectRow){
  //         $scope.gridApi.selection.selectRow($scope.gridOptions.data[0]);
          
  //       }
  //     });
  //   });

    $scope.info = {};

  $http.get('http://10.10.0.73:8080/getQueaus')
    .success(function(data) {
      $scope.gridOptions.data = data;

      });
}]);
