<%@page language="java" pageEncoding="utf-8"
   contentType="text/html;charset=utf-8"
%><%@taglib prefix="t" tagdir="/WEB-INF/tags"
%><%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
%><%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"
%><c:set
   var="pageTitle"
   value="Hay conexi&oacute;n en el servidor?"
   scope="session"
/><t:page><jsp:body>

<h2 id="message">${fn:escapeXml(message)}</h2>
<h3>Tenemos conexi&oacute;n con MySQL: ${is_connected}</h3>

</jsp:body></t:page>
