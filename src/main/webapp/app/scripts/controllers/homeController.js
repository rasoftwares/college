app.controller('homeController', function($scope, $http){

   $( "#accordion").accordion({
     heightStyle: "fill-content"
      });

    $scope.phone = sample.College.phone;
    $scope.address = sample.College.address;
    $scope.fax = sample.College.fax;
    $scope.email = sample.College.email;
    $scope.website = sample.College.website;
    $scope.details = sample.Branch;

    $scope.details = function(value) {

    console.log("value" + value);
    var even = _.find([1, 2, 3, 4, 5, 6], function(num){ return num % 2 == 0; });
    console.log(even);
    //jQuery.each( obj, function( i, val ) {
    //  console.log()
    //});
    return ;
}


$scope.allColleges = [
  {
    "code": "3462",
    "name": "ARIYALUR ENGINEERING COLLEGE",
    "branches": [
      {
        "code": "CS",
        "name": "COMPUTER SCIENCE AND ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "89.5"
          },
          {
            "cname": "BCM",
            "mark": "10"
          },
          {
            "cname": "BC",
            "mark": "20"
          },
          {
            "cname": "MBC",
            "mark": "10"
          },
          {
            "cname": "SCA",
            "mark": "10"
          },
          {
            "cname": "SC",
            "mark": "10"
          },
          {
            "cname": "ST",
            "mark": "10"
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2013",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "ME",
        "name": "MECHANICAL ENGINEERING",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "96.75"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": "81.25"
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2013",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "CE",
        "name": "CIVIL ENGINEERING",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "97.75"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2013",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "EC",
        "name": "ELECTRONICS AND COMMUNICATION ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "102.75"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2013",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "EE",
        "name": "ELECTRICAL AND ELECTRONICS ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "121.5"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2013",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      }
    ]
  },
  {
    "code": "3781",
    "name": "K.K.C COLLEGE OF ENGINEERING AND TECHNOLOGY",
    "branches": [
      {
        "code": "CS",
        "name": "COMPUTER SCIENCE AND ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "92.75"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "45",
        "yearofstartingofcourse": "2010",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "ME",
        "name": "MECHANICAL ENGINEERING",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "97.75"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "90",
        "yearofstartingofcourse": "2010",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "CE",
        "name": "CIVIL ENGINEERING",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "105"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "45",
        "yearofstartingofcourse": "2010",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "EE",
        "name": "ELECTRICAL AND ELECTRONICS ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "82.25"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "45",
        "yearofstartingofcourse": "2010",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      }
    ]
  },
  {
    "code": "3857",
    "name": "MEENAKSHI RAMASWAMY ENGINEERING COLLEGE",
    "branches": [
      {
        "code": "CS",
        "name": "COMPUTER SCIENCE AND ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "81.75"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2009",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "EE",
        "name": "ELECTRICAL AND ELECTRONICS ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "86"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "120",
        "yearofstartingofcourse": "2009",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "CE",
        "name": "CIVIL ENGINEERING",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "87.75"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "120",
        "yearofstartingofcourse": "2010",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "EC",
        "name": "ELECTRONICS AND COMMUNICATION ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "107.5"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2009",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "ME",
        "name": "MECHANICAL ENGINEERING",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "98.75"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": "88"
          },
          {
            "cname": "MBC",
            "mark": "80"
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "120",
        "yearofstartingofcourse": "2009",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      }
    ]
  },
  {
    "code": "3466",
    "name": "NELLIANDAVAR INSTITUTE OF TECHNOLOGY",
    "branches": [
      {
        "code": "EC",
        "name": "ELECTRONICS AND COMMUNICATION ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "143.25"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "30",
        "yearofstartingofcourse": "2013",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "CE",
        "name": "CIVIL ENGINEERING",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "121.25"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "30",
        "yearofstartingofcourse": "2013",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "CS",
        "name": "COMPUTER SCIENCE AND ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "113.5"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "30",
        "yearofstartingofcourse": "2013",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "ME",
        "name": "MECHANICAL ENGINEERING",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "96.5"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2013",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      }
    ]
  },
  {
    "code": "3016",
    "name": "UNIVERSITY COLLEGE OF ENGINEERING, ARIYALUR",
    "branches": [
      {
        "code": "CE",
        "name": "CIVIL ENGINEERING",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "161.75"
          },
          {
            "cname": "BCM",
            "mark": "110.75"
          },
          {
            "cname": "BC",
            "mark": "138.5"
          },
          {
            "cname": "MBC",
            "mark": "150.25"
          },
          {
            "cname": "SCA",
            "mark": "109.25"
          },
          {
            "cname": "SC",
            "mark": "137.75"
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2008",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "CS",
        "name": "COMPUTER SCIENCE AND ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "148.5"
          },
          {
            "cname": "BCM",
            "mark": "108"
          },
          {
            "cname": "BC",
            "mark": "134.75"
          },
          {
            "cname": "MBC",
            "mark": "137"
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": "131"
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2008",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "EC",
        "name": "ELECTRONICS AND COMMUNICATION ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "165"
          },
          {
            "cname": "BCM",
            "mark": "158"
          },
          {
            "cname": "BC",
            "mark": "141.5"
          },
          {
            "cname": "MBC",
            "mark": "153.25"
          },
          {
            "cname": "SCA",
            "mark": "113.25"
          },
          {
            "cname": "SC",
            "mark": "142.25"
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2008",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "EE",
        "name": "ELECTRICAL AND ELECTRONICS ENGG.",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "151.5"
          },
          {
            "cname": "BCM",
            "mark": "112.5"
          },
          {
            "cname": "BC",
            "mark": "131.5"
          },
          {
            "cname": "MBC",
            "mark": "148.75"
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": "133.25"
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2009",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "ME",
        "name": "MECHANICAL ENGINEERING",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "166.25"
          },
          {
            "cname": "BCM",
            "mark": "155.75"
          },
          {
            "cname": "BC",
            "mark": "151"
          },
          {
            "cname": "MBC",
            "mark": "162"
          },
          {
            "cname": "SCA",
            "mark": "130.5"
          },
          {
            "cname": "SC",
            "mark": "150.75"
          },
          {
            "cname": "ST",
            "mark": "89"
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2008",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "XC",
        "name": "CIVIL ENGINEERING - TAMIL MEDIUM",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "86.25"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2010",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      },
      {
        "code": "XM",
        "name": "MECHANICAL ENGINEERING - TAMIL MEDIUM",
        "cutoff": [
          {
            "cname": "OC",
            "mark": "131"
          },
          {
            "cname": "BCM",
            "mark": ""
          },
          {
            "cname": "BC",
            "mark": ""
          },
          {
            "cname": "MBC",
            "mark": ""
          },
          {
            "cname": "SCA",
            "mark": ""
          },
          {
            "cname": "SC",
            "mark": ""
          },
          {
            "cname": "ST",
            "mark": ""
          }
        ],
        "approvedintake": "60",
        "yearofstartingofcourse": "2010",
        "nbaaccredited": "No",
        "accreditionvalidupto": "--"
      }
    ]
  }
];
$scope.branches = undefined;


$scope.fetchCollegeDetails = function ($item, $model, $label, $event){
//typeahead-on-select($item, $model, $label, $event)
//console.log($item);
$scope.branches = $item.branches;
console.log("-------->");
console.log($item.branches);
$scope.collegeName = $item.name;
$scope.college_Code= $item.code;
//console.log( $model);
//console.log($label);
//console.log($event);
console.log($scope.branches);
console.log($scope.college_Code);
$scope.prepareChart($item);

};

//cutoff
 $scope.prepareChart = function(data) {
      console.log("<--------------------->");
      console.log(data);
       	var cname = [];
      	var mark = [];
      	var chartData = [];
        console.log(data.branches);
        var branches = data.branches;
      	for(var i in branches) {
      		console.log(branches[i])
      		var cutoff = branches[i].cutoff;
      		var cutOffArr = [];
      		for(var j in cutoff) {
      			console.log(cutoff[j]);
      			console.log(JSON.stringify(cutoff[j]))
      			cname.push(cutoff[j].cname);
      			mark.push(cutoff[j].mark);
      			item = {};
      			item["cname"] = cutoff[j].cname;
      			item["mark"] = cutoff[j].mark;
      			cutOffArr.push(item);
      		}
      		chartData.push(cutOffArr);
      		console.log("--->" + JSON.stringify(cutOffArr));
        	createChart(cutOffArr);

      }



  }



  function createChart(data){
  	  var w = 100;
  	  var h = 100;
  	  var r = h/2;
  	  var aColor = [
  	  	 'rgb(144,238,144)',
  	  	 'rgb(255,127,80)',
  	  	 'rgb(154,205,50)',
  	  	 'rgb(0,255,255)',
  	  	 'rgb(100,149,237)',
         'rgb(0,149,237)',
         'rgb(0,255,255)'
  	  ];

  	   console.log(data);
       var vis = d3.select('#chart').append("svg:svg").data([data]).attr("width", w).attr("height", h).append("svg:g").attr("transform", "translate(" + r + "," + r + ")");

       var pie = d3.pie().value(function(d){return d.mark;});

       // Declare an arc generator function
       var arc = d3.arc();
       arc.outerRadius(r);
       arc.innerRadius(r/4);


       var arcs = vis.selectAll("g.slice").data(pie).enter().append("svg:g").attr("class", "slice");
       arcs.append("svg:path")
      		 .attr("fill", function(d, i){return aColor[i];})
      		 .attr("d", function (d) {return arc(d);})
       ;

       // Add the text
       arcs.append("svg:text")
      		 .attr("transform", function(d){
      				 d.innerRadius = 10;
      				 d.outerRadius = r;
      				 return "translate(" + arc.centroid(d) + ")";}
      		 )
      		 .attr("text-anchor", "middle")
      		 .attr("font-size", "8px")
      		 .text( function(d, i) {return data[i].cname + "-" + data[i].mark;});

           /* var title = d3.select("svg:g").append("text")
           .attr("transform","translate(" + w + "," + h + ")")
           .attr("class","title");*/


           /*d3.select("svg").append("text")
      			.attr("x",300)
      			.attr("y",300)
      			.attr("font-size", "18px")
      			.style('fill', 'red')
      			.text("ME");*/

      }


      var _selected;

      $scope.selected = undefined;


 $(window).on('keypress', function(event) {
 $('#chart').html(" ");
 });


});