<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/bootstrap.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/bootstrap-responsive.min.css'/>"/>        
        <link rel="stylesheet" href="<c:url value='/stylesheets/font-awesome.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/style.css'/>"/>                
        <title>DEW - Plantilla modelo</title>
    </head>
    <body>                
        <tiles:insertAttribute name="body" />
        <script src="<c:url value='/javascript/jquery-1.8.1.min.js'/>" type="text/javascript"></script>
        <script src="<c:url value='/javascript/bootstrap.min.js'/>"></script>
    </body>
</html>