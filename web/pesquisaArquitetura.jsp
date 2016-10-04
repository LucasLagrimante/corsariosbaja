<%-- 
    Document   : pesquisaArquitetura
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
        <title>Pesquisa de Arquitetura</title>
    </head>
    <body>
        <h1>Pesquisa de Arquitetura</h1>
        <table border="1">
            <tr>
                <th>Código Arquitetura</th>
                <th>Nome Arquitetura</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${arquiteturas}" var="arquitetura">
                <tr>
                    <td><c:out value="${arquitetura.idArquitetura}" /></td>
                    <td><c:out value="${arquitetura.nome}" /></td>
                    <td><a href="ManterArquiteturaController?acao=prepararEditar&idArquitetura=<c:out value="${arquitetura.idArquitetura}" />">Editar</a></td>
                    <td><a href="ManterArquiteturaController?acao=prepararExcluir&idArquitetura=<c:out value="${arquitetura.idArquitetura}" />">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>
        <form action="ManterArquiteturaController?acao=preparaIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>
    </body>
</html>