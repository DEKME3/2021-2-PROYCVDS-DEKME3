<!DOCTYPE html>
<html xmlns="http://www.w3c.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:pt="http://xmlns.jcp.org/jsf/passthrough"
      xmlns:f="http://java.sun.com/jsf/core"
      xmlns:p="http://primefaces.org/ui">
    <h:head>
        <link rel="stylesheet" type="text/css" href="css/login.css"/>
    </h:head>
    <h:body>
        <div class="item1">
            <form id="login-form" method="post" action="#">
                <div class="forma1" text-centet>
                    <img src="img/loginImagen.png" height="200" width="20
                    0">
                    <p><strong>Bienvenido al Sistema</strong></p> 
                </div>
                <div class="forma1">
                    <label>User</label>
                    <input class="form-control" type="text" name="txtnom" placeholder="Ingrese su Usuario:" value="#{LoginBean.nombre}">
                    <p:inputText type="email" name="txtnom" id="name" placeholder="Name" value="#{LoginBean.nombre}"/><br/>
                </div>
                <div class="forma1">
                    <label>Password</label>
                    <input type="password" name="txtPassword" placeholder="Ingrese su clave:" class="form-control" value="#{LoginBean.clave}"> 
                    <p:inputText type="password" name="txtPassword" id="password" placeholder="Password"  value="#{LoginBean.clave}"/>
                </div>
                <input class="btn btn-danger btn-block" type="submit" name="accion" value="Ingresar" action="#{LoginBean.login()}"> 
            </form>
        </div>
    </h:body>
</html>



		
		