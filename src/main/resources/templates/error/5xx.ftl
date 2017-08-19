<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Error</title>
</head>
<body>
<h1>server error</h1>
<p>
<div style="color:red;font-size:large">error code: ${status}-${error}</div>
<div style="color:red;font-size:medium">error msg: ${exception!},${message!}</div>

<div>
	<div id="trace" style="color:grey;font-size:small;display: none;border: 1px solid black;padding: 10px;">${trace!}</div>
</div>
</p>
</body>
</html>