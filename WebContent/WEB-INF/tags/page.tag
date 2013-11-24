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
	<li><a href="#">Test</a>
		<ul>
			<li><a href="${root}/test/time">Time</a></li>
		</ul>
		<ul>
			<li><a href="#">MySQL</a>
				<ul>
				<li><a href="${root}/test/mysql/connection">
					Connection</a></li>
				</ul>
			</li>
		</ul>
	</li>
</ul>
</div>

<div id="content">
<jsp:doBody/>
</div>
</body>
</html>

