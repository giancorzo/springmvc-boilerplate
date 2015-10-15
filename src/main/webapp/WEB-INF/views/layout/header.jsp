<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container">
      <a class="brand" href="/home">DEW - Plantilla de Trabajo</a>
      <div class="nav-collapse" id="main-menu">
        <ul class="nav pull-right" id="main-menu-right">
          <li><div class="texto">Bienvenido ${credential.correo}</div></li>
          <li class="divider-vertical"></li>
          <li><a href="<c:url value='/pages/usuarios/logout'/>">Salir</a></li>
        </ul>
      </div>
    </div>
  </div>
</div>