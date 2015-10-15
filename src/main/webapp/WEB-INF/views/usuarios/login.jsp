<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<div class="header">
  <div class="container">
    <div class="pht-logo"></div>
    <div class="contacto pull-right">
      <i class="icon-envelope"></i>pcisgcor@upc.edu.pe<br>
      <i class="icon-phone"></i>313.3333
    </div>
  </div>  
</div>
<div class="container">
  <div class="texto-publicitario pull-left">    
    <p>La plantilla de desarrollo del curso de DEW tiene como objetivo orientar a los alumnos en el desarrollo del proyecto
       del curso.</p>
    
    <p>La plantilla desarrolla el primer ejemplo, el cual es el login de usuario y su respectivo mantenimiento, el cual será
       tomado como base para futuros desarrollos.</p>
    
    <p>Actualmente esta es la versión 1.0.1 del desarrollo, se espera complementar esta plantilla con más información de ejemplo
       para el beneficio del alumno.</p>
  </div>
  <div class="mid-container wrapper pull-right">
    <h1 class="title">DEW</h1>
    <form:form action="autenticar" method="post" commandName="credential" cssClass="form-horizontal">
        <ul class="fields">
          <li>
            <i class="icon-user"></i>
            <form:input path="correo" autocomplete="off" placeholder="Ingrese su email"></form:input>
            <form:errors path="correo" cssstyle="color:red"></form:errors>
          </li>
          <li>
            <i class="icon-key"></i>
            <form:password path="password" autocomplete="off" placeholder="Ingrese su contraseña"></form:password>
            <form:errors path="password" cssstyle="color:red"></form:errors>                        
          </li>
        </ul>

        <div class="mid-form">
          <input class="btn btn-primary btn-large pull-right" name="commit" type="submit" value="Ingresar">
        </div>        
    </form:form>
  </div>
</div>