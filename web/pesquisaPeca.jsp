<%-- 
    Document   : pesquisaPeca
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
        <title>Pesquisa de Peca</title>
    </head>
    <body>
        <h1>Pesquisa de Peca</h1>
        <table border="1">
            <tr>
                <th>Código Peca</th>
                <th>Nome Peca</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${pecas}" var="peca">
                <tr>
                    <td><c:out value="${peca.idPeca}" /></td>
                    <td><c:out value="${peca.nome}" /></td>
                    <td><a href="ManterPecaController?acao=prepararEditar&idPeca=<c:out value="${peca.idPeca}" />">Editar</a></td>
                    <td><a href="ManterPecaController?acao=prepararExcluir&idPeca=<c:out value="${peca.idPeca}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterPecaController?acao=preparaIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>