<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="DEW - Plantilla de trabajo">
        <meta name="author" content="Giancarlo Corzo">

        <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/bootstrap.css'/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/bootstrap-responsive.min.css'/>"/>        
        <link rel="stylesheet" href="<c:url value='/stylesheets/font-awesome.css'/>">
        <link rel="stylesheet" type="text/css" href="<c:url value='/stylesheets/style.css'/>"/>                
        <title>DEW - Plantilla modelo</title>
    </head>
    <body class="app">
        <tiles:insertAttribute name="header" />
        <div class="container">
            <tiles:insertAttribute name="subheader" />
            <tiles:insertAttribute name="body" />
        </div><!-- /container -->
        <script src="<c:url value='/javascript/jquery-1.8.1.min.js'/>" type="text/javascript"></script>
        <script src="<c:url value='/javascript/bootstrap.min.js'/>"></script>        
    </body>
</html>