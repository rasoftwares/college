var app = angular.module('collegeApp', ['ngRoute','ui.bootstrap']);


/* Routing logic of the app */
app.config(['$routeProvider', function($routeProvider){
   var src_dir = "app/views/";
  //Source directory where all of the html fragments are placed
  $routeProvider.
      when('/home', {
      templateUrl: src_dir +'home.html'
      }).
      when('/allbranches', {
        templateUrl:  src_dir +'branches.html', controller: "branchesController"
      }).
      when('/allcolleges', {
        templateUrl:  src_dir +'college.html', controller: "collegesController"
      }).
      when('/cutoffmarks', {
        templateUrl:  src_dir +'cutoff.html', controller: "cutoffController"
      }).
      otherwise({
        redirectTo: '/home'
      });
}]);


app.controller('AppController', function($scope){

$scope.searchTxt = "";

});
