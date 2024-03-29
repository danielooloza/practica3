<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<jsp:useBean id="saveProject" class="com.generation.jwd.p1.beans.Project" scope="request"></jsp:useBean>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Crear proyecto | Banana GEST</title>
        <link rel="stylesheet" type="text/css" href="css/createproject.css">
    </head>
    <body>
        <header>
            <div class="head"><img src="images/profile.png" width="55" height="55"><h3>Bienvenido/a ${id_user}</h3>
            <a href="#">Editar perfil</a></div>
            <div class="head"><h1>Banana GEST</h1><a href="homeuser.jsp"><img src="images/bananas_medio.png"/></a></div>
            <div class="head"><h4><a href="LogoutServlet">Logout</a></h4></div>
        </header>
            <h2>Registro de nuevo proyecto</h2>
            <hr>
        <main>
            <form method="post" action="createproject" id ="createproject">
                <p>
                    <table id="basic">
                        <tr class="contenttable">
                            <td class="namecontent">Nombre</td>
                            <td class="contenttable">
                                <input style="background-color:#F5BFB2;" type="text" placeholder="Nombre del proyecto" required="true"
                                name="name" id="name" autofocus/>
                            </td>
                        </tr>
                        <tr>
                            <td class="namecontent">Descripción</td>
                            <td class="contenttable">
                                <textarea id="description" name="desc" required="true" rows="15" cols="60"
                                 ></textarea>
                            </td>
                        </tr>
                         <tr>
                            <td class="namecontent">Fecha de inicio</td>
                            <td class="contenttable">
                                <input id="date_start" type="date" name="dateBegin" required="true"/>               
                            </td>
                        </tr>
                        <tr>
                            <td class="namecontent">Fecha de fin</td>
                            <td class="contenttable">
                                <input id="date_end" type="date" name="dateEnd" required="true"/>               
                            </td>
                        </tr>   
                        <tr>
                            <td class="namecontent">Usuario asignado</td>
                            <td class="contenttable">
                                <select  class="selectionbuton" id="id_user" name="id_user" required="true">
                                    <c:forEach items="${userList}" var="user">
	                                    <option value="${user}">${user}</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>                 
                    </table>
                <div id="boton">
                    <button  style="widtd:200px; height:50px;">Crear proyecto</button>
                </div>
            </form>
        </main>
        <footer>
            <span>Banana GEST - Todos los derechos reservados</span>
        </footer>
    </body>
    </html>