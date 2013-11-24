<%@taglib prefix="t" tagdir="/WEB-INF/tags"
%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
%><!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
	</head>
<body>
<div id="header">
	<div id="pageTitle">
		<h1>${pageTitle}</h1>
	</div>
</div>

<div id="nav">
<ul id="page-menu">
	<li><a href="${root}/">Inicio</a></li>
	<li><a href="#">Item 1</a>
		<ul>
			<li><a href="#">Sub Item 1.1</a></li>
		</ul>
	</li>
	<li><a href="#">Item 2</a>
		<ul>
			<li><a href="#">Sub Item 2.1</a></li>
		</ul>
	</li>
	<li><a href="#">Item 3</a>
		<ul>
			<li><a href="#">Sub Item 3.1</a></li>
			<li><a href="#">Sub Item 3.2</a></li>
			<li><a href="#">Sub Item 3.3</a></li>
		</ul>
	</li>
</ul>
</div>

<div id="content">
<jsp:doBody/>
</div>
</body>
</html>

