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
        <div>
            <div class="item1">
                <img src="img/logo.png" alt="logo"/>
                <h3 id="title" class="neonText">Solidaridad Escuela</h3>
                <p>Ingresa tu usuario</p>
                <form>
                    <label for="usuario">Usuario:</label>
                    <input type="text" id="usuario" name="usuario" value="#{LoginBean.nombre}"/>
                    <label for="pwd">Contraseña:</label>
                    <input type="password" id="pwd" name="pwd" value="#{LoginBean.clave}"/>
                    
                </form>
            </div>
            <div class="item2">
                <img src="img/login.gif" alt="gifLogin"/> 
            </div>

            <p:commandButton type="submit" value="Ingresar" action="#{LoginBean.login()}"/>
        </div>
    </h:body>
</html>
