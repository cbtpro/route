function renderBar() {
	var promise = new Promise((resolve, reject)=>{
		d3.json('/api/data/dataSet',function(json) {
			resolve(json);
		});
	});
	promise.then(data=>{
		barChart(data);
	});
}
renderBar();
function renderScatter() {
	var scatterPromise = new Promise((resolve, reject)=>{
		d3.json('/api/data/scatterDataSet', json=>{
			resolve(json);
		})
	});
	scatterPromise.then(data=>{
		scatterChart(data);
	});
}
renderScatter();
d3.select('p.updateChart')
.on('click', ()=>{
	renderBar();
	renderScatter();
});
function draw(dataset) {
	d3.select('dataView')
	.data(dataset)
	.enter()
	.append('div')
	.classed('bar', true)
	.style('height', data=>{
		var barHeight = data * 5;
		return barHeight + 'px';
	});
};
var w = 800,h = 400,barPadding = 1;
function drawSvg(dataSet) {
	var svg = d3.select('body')
	.append('svg')
	.attr('width', w)
	.attr('height', h);
	var circles = svg.selectAll('circle')
	.data(dataSet)
	.enter()
	.append('circle');
	circles.attr('cx', (d, i)=>{
		return (i * 50) + 25;
	})
	.attr('cy', h/2)
	.attr('r', d=>{
		return d;
	})
	.attr('fill', 'yellow')
	.attr('stroke', 'orange')
	.attr('stroke-width', d=>{
		return d/2;
	});
}
var padding = 30;
var scatterSvg;
function scatterChart(dataSet) {
	//生成比例尺
	var xScale = d3.scaleLinear()
	.domain([0, d3.max(dataSet, d=>{ return d[0]})])
	.range([padding, w - padding])
	.nice();
	
	var yScale = d3.scaleLinear()
	.domain([0, d3.max(dataSet, d=>{ return d[1]})])
	.range([h - padding, padding])
	.nice();
	
	var rScale = d3.scaleLinear()
	.domain([0, d3.max(dataSet, d=>{ return d[1] })])
	.range([2, 5])
	.nice();
	if(!d3.select('#scatterChart').empty()) {
		scatterSvg.selectAll('circle')
		.data(dataSet)
		.transition().duration(1000)
		.attr('cx', d=>{
			return xScale(d[0]);
		})
		.attr('cy', d=>{
			return yScale(d[1]);
		})
		.attr('r', d=>{
			return rScale(d[1]);
		});
	} else {
		
		//生成横轴和纵轴
		var xAxis = d3.axisBottom(xScale);
		var yAxis = d3.axisLeft(yScale);
		
		scatterSvg = d3.select('#dataView')
		.append('svg')
		.attr('id', 'scatterChart')
		.attr('width', w)
		.attr('height', h);
		scatterSvg.selectAll('circle')
		.data(dataSet)
		.enter()
		.append('circle')
		.attr('cx', d=>{
			return xScale(d[0]);
		})
		.attr('cy', d=>{
			return yScale(d[1]);
		})
		.attr('r', d=>{
			return rScale(d[1]);
		});
		scatterSvg.append('g')
		.attr('transform', 'translate(0, ' + (h - padding) + ')')
		.call(xAxis);
		scatterSvg.append('g')
		.attr('transform', 'translate(' + padding + ', 0)')
		.call(yAxis);
	}
}
var barSvg;
function barChart(dataSet) {
	//生成比例尺
	var xScale = d3.scaleLinear()
	.domain([0, d3.max(dataSet, d=>{ return d})])
	.range([padding, w - padding])
	.nice();
	
	var yScale = d3.scaleLinear()
	.domain([0, d3.max(dataSet, d=>{ return d})])
	.range([h - padding, padding])
	.nice();
	
	var rScale = d3.scaleLinear()
	.domain([0, d3.max(dataSet, d=>{ return d })])
	.range([2, 5])
	.nice();
	
	//生成横轴和纵轴
	var xAxis = d3.axisBottom(xScale);
	var yAxis = d3.axisLeft(yScale);
	
	var factor = multipleFactor(dataSet);
	if(!d3.select('#barChart').empty()) {
		barSvg.selectAll('rect')
		.data(dataSet)
		.transition().duration(1000)
		.attr('x', (d, i)=>{
			//return xScale(i);
			return ((w - barPadding) / dataSet.length) * i + padding;
		})
		.attr('y', d=>{
			return h - yScale(d) - padding;
		})
		.attr('width', (w - barPadding*2 - padding*2) / dataSet.length)
		.attr('height', d=>{
			return yScale(d);
		});
	} else {
		barSvg = d3.select('#dataView')
		.append('svg')
		.attr('id', 'barChart')
		.attr('width', w)
		.attr('height', h);
		var circles = barSvg.selectAll('rect')
		.data(dataSet)
		.enter()
		.append('rect');
		
		circles.attr('x', (d, i)=>{
			//return xScale(i);
			return ((w - barPadding) / dataSet.length) * i + padding;
		})
		.attr('y', d=>{
			return h - yScale(d) - padding;
		})
		.attr('width', (w - barPadding*2 - padding*2) / dataSet.length)
		.attr('height', d=>{
			return yScale(d);
		})
		.attr('fill', (d, i)=>{
			return colors[i];
		})
		.attr('stroke', (d, i)=>{
			return borderColor[i];
		});
		var text = barSvg.selectAll('text')
		.data(dataSet)
		.enter()
		.append('text');
		text.text(d=>{
			return d;
		})
		.attr('x', (d, i)=>{
			return i * (w / dataSet.length) + (w / dataSet.length - barPadding) / 2;
		})
		.attr('y', d=>{
			return h - yScale(d) + 11;
		})
		.attr('font-family', 'sans-serif')
		.attr('font-size', '11px')
		.attr('fill', 'white')
		.attr('text-anchor', 'middle');
	
		barSvg.append('g')
		.attr('transform', 'translate(0, ' + (h - padding) + ')')
		.call(xAxis);
		barSvg.append('g')
		.attr('transform', 'translate(' + padding + ', 0)')
		.call(yAxis);
	}
}
function multipleFactor(array) {
	var max = d3.max(array);
	return h/max;
}
var colors = ['rgba(255, 99, 132, 0.2)',
	'rgba(54, 162, 235, 0.2)',
	'rgba(255, 206, 86, 0.2)',
	'rgba(75, 192, 192, 0.2)',
	'rgba(153, 102, 255, 0.2)',
	'rgba(255, 159, 64, 0.2)',
	'rgba(0, 204, 0, 0.2)',
	'rgba(153, 102, 102, 0.2)',
	'rgba(153, 153, 51, 0.2)',
	'rgba(204, 0, 0, 0.2)',
	'rgba(255, 255, 51, 0.2)',
	'rgba(102, 102, 153, 0.2)'];
var borderColor = [
	'rgba(255,99,132,1)',
	'rgba(54, 162, 235, 1)',
	'rgba(255, 206, 86, 1)',
	'rgba(75, 192, 192, 1)',
	'rgba(153, 102, 255, 1)',
	'rgba(255, 159, 64, 1)',
	
	'rgba(0, 204, 0, 1)',
	'rgba(153, 102, 102, 1)',
	'rgba(153, 153, 51, 1)',
	'rgba(204, 0, 0, 1)',
	'rgba(255, 255, 51, 1)',
	'rgba(102, 102, 153, 1)'
];