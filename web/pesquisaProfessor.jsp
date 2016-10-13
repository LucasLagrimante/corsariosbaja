<%-- 
    Document   : pesquisaProfessor
    Created on : 20/09/2016, 09:17:12
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Professor</title>
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        <h1>Pesquisa de Professor</h1>
        <table border="1">
            <tr>
                <th>Código Professor</th>
                <th>Nome Professor</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${professores}" var="professor">
                <tr>
                    <td><c:out value="${professor.idProfessor}" /></td>
                    <td><c:out value="${professor.nome}" /></td>
                    <td><a href="ManterProfessorController?acao=prepararEditar&idProfessor=<c:out value="${professor.idProfessor}" />">Editar</a></td>
                    <td><a href="ManterProfessorController?acao=prepararExcluir&idProfessor=<c:out value="${professor.idProfessor}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterProfessorController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>
