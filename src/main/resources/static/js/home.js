var promise = new Promise((resolve, reject)=>{
	d3.json('/api/data/dataSet',function(json) {
		resolve(json);
	});
});
promise.then(data=>{
	barChart(data);
});
var scatterPromise = new Promise((resolve, reject)=>{
	d3.json('/api/data/scatterDataSet', json=>{
		resolve(json);
	})
});
scatterPromise.then(data=>{
	scatterChart(data);
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
var w = 500,h = 100,barPadding = 1;
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
var padding = 20;
function scatterChart(dataSet) {
	var xScale = d3.scaleLinear()
	.domain([0, d3.max(dataSet, d=>{ return d[0]})])
	.range([padding, w - padding]);
	var yScale = d3.scaleLinear()
	.domain([0, d3.max(dataSet, d=>{ return d[1]})])
	.range([h - padding, padding]);
	var rScale = d3.scaleLinear()
	.domain([0, d3.max(dataSet, d=>{ return d[1] })])
	.range([2, 5]);
	var svg = d3.select('body')
	.append('svg')
	.attr('width', w)
	.attr('height', h);
	svg.selectAll('circle')
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
}
function barChart(dataSet) {
	var factor = multipleFactor(dataSet);
	var svg = d3.select('body')
	.append('svg')
	.attr('width', w)
	.attr('height', h);
	var circles = svg.selectAll('rect')
	.data(dataSet)
	.enter()
	.append('rect');
	circles.attr('x', (d, i)=>{
		return i * (w / dataSet.length);
	})
	.attr('y', d=>{
		return h - d * factor;
	})
	.attr('width', w / dataSet.length - barPadding)
	.attr('height', d=>{
		return d * factor;
	})
	.attr('fill', d=>{
		return 'rgb(0, 0, ' + (d * 10) + ')';
	});
	var text = svg.selectAll('text')
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
		return h - d * factor + 11;
	})
	.attr('font-family', 'sans-serif')
	.attr('font-size', '11px')
	.attr('fill', 'white')
	.attr('text-anchor', 'middle');
}
function multipleFactor(array) {
	var max = d3.max(array);
	return h/max;
}