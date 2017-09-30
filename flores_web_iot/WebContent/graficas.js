/**
 * 
 */

//alert('estoy en js');

$.getJSON("http://localhost:8180/flores_web_iot/config/classjson/datosJson", function(data){
	
}).done(function(data){
	
	$.each(data, function(i,item){
		
		if(item.categoria == "Iris-virginica"){
			
			virginica = {sl : item.sl, 
					sw : item.sw, pl : item.pl, pw : item.pw};
			}
		
		if(item.categoria == "Iris-versicolor"){
			
			versicolor = {sl : item.sl, 
					sw : item.sw, pl : item.pl, pw : item.pw};
			}
		
			
		if(item.categoria == "Iris-setosa"){
			
			setosa = {sl : item.sl, 
					sw : item.sw, pl : item.pl, pw : item.pw};
			}
			
			
	});
	
/*	alert("sl " + virginica.sl + " sp " + virginica.sw + " pl " + virginica.pl + " pw " + virginica.pw);
	alert(versicolor.sl + " sp " + versicolor.sw + " pl " + versicolor.pl + " pw " + versicolor.pw);
	alert(setosa.sl + " sp " + setosa.sw + " pl " + setosa.pl + " pw " + setosa.pw);*/

	Highcharts.chart('container', {
	    chart: {
	        type: 'column'
	    },
	    title: {
	        text: 'Datos de Petalos'
	    },
	    xAxis: {
	        categories: [
	            'Iris Virginica',
	            'Iris Setosa',
	            'Iris Versicolor'
	        ]
	    },
	    yAxis: [{
	        min: 0,
	        title: {
	            text: 'Promedio'
	        }
	    }, {
	        title: {
	            text: 'Promedio'
	        },
	        opposite: true
	    }],
	    legend: {
	        shadow: false
	    },
	    tooltip: {
	        shared: true
	    },
	    plotOptions: {
	        column: {
	            grouping: false,
	            shadow: false,
	            borderWidth: 0
	        }
	    },
	    series: [{
	        name: 'Sepal Length',
	        color: 'rgba(165,170,217,1)',
	        data: [
	        	virginica.sl, 
	        	setosa.sl, 
	        	versicolor.sl
	        	],
	        pointPadding: 0.3,
	        pointPlacement: -0.2
	    }, {
	        name: 'Sepal Width',
	        color: 'rgba(126,86,134,.9)',
	        data: [
	        	virginica.sw, 
	        	setosa.sw, 
	        	versicolor.sw
	        ],
	        pointPadding: 0.4,
	        pointPlacement: -0.2
	    }, {
	        name: 'Petal Length',
	        color: 'rgba(248,161,63,1)',
	        data: [
	        	virginica.pl, 
	        	setosa.pl, 
	        	versicolor.pl
	        ],
	       /* tooltip: {
	            valuePrefix: '$',
	            valueSuffix: ' M'
	        },*/
	        pointPadding: 0.3,
	        pointPlacement: 0.2,
	        yAxis: 1
	    }, {
	        name: 'Petal Width',
	        color: 'rgba(186,60,61,.9)',
	        data: [
	        	virginica.pw, 
	        	setosa.pw, 
	        	versicolor.pw
	        ],
	       /* tooltip: {	            valuePrefix: '$',
	            valueSuffix: ' M'
	        },*/
	        pointPadding: 0.4,
	        pointPlacement: 0.2,
	        yAxis: 1
	    }]
	});

	
});
	
	
	
	