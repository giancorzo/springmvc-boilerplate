<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Nuevo Usuario</h1><br/><br/>
    <form:form action="new" method="post" commandName="usuario" 
               enctype="multipart/form-data" cssClass="form-horizontal">
        <div class="row">
            <div class="control-group">
                <label class="control-label" for="nombre">Nombre:</label>
                <div class="controls">
                    <form:input path="nombre"></form:input>
                    <form:errors path="nombre" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="correo">Correo electrónico:</label>
                <div class="controls">
                    <form:input path="correo"></form:input>
                    <form:errors path="correo" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="password">Password:</label>
                <div class="controls">
                    <form:password path="password"></form:password>
                    <form:errors path="password" cssstyle="color:red"></form:errors>
                </div>
            </div> 
            <div class="control-group">
                <label class="control-label" for="avatar">Avatar:</label>
                <div class="controls">
                    <form:input path="avatar" type="file"/>
                </div>
            </div>
        </div>
        <div class="actions" style="margin-left: 160px;">
            <input name="" value="Save" type="submit" class="btn btn-primary">
            <a style="margin-left: 5px;" href="<c:url value='/pages/usuarios/index'/>">Cancelar</a>
        </div>                
    </form:form>
</div>
