<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Pessoa</title>
        <link rel="stylesheet" type="text/css"  href="estilo.css" />
        <link rel="shortcut icon" href="images/favicon.ico">
    </head>
    <body>
        
        <div align="center">
            <h2 align="center">Manter Pessoa - ${operacao}</h2>
            <form action="ManterPessoaController?acao=confirmar${operacao}" method="POST" name="frmManterPessoa" onsubmit="return validarFormulario(this)">
                <table>
                    <tr>
                        <td align="left">ID:</td>
                        <td align="right"><input name="txtIdPessoa" type="text" value="${pessoa.idPessoa}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Nome:</td>
                        <td align="right"><input name="txtNome" type="text" value="${pessoa.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Cpf:</td>
                        <td align="right"><input name="txtCpf" type="text" value="${pessoa.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Logradouro:</td>
                        <td align="right"><input name="txtLogradouro" type="data" value="${pessoa.logradouro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Cep:</td>
                        <td align="right"><input name="txtCep" type="text" value="${pessoa.cep}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Bairro:</td>
                        <td align="right"><input name="txtBairro" type="text"  value="${pessoa.bairro}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Uf:</td>
                        <td align="right"><input name="txtUf" type="text"  maxlength="2"  value="${pessoa.uf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Número:</td>
                        <td align="right"><input type="text" name="txtNumero"  value="${pessoa.numero}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td align="left">Telefone:</td>
                        <td align="right"><input type="text" name="txtTelefone"  value="${pessoa.telefone}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center"> <input type="submit" value="Confirmar"></td>
                    </tr>
                </table>
            </form>
         <SCRIPT language="JavaScript">
            
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++) 
                { 
                    umCaracter = valor.charAt(i); 
                    if (caracteresValidos.indexOf(umCaracter) == -1) 
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }
            function validarFormulario(form) { 
                var mensagem;
                mensagem = "";
                if (form.txtIdPessoa.value == ""){
                    mensagem = mensagem + "Informe o ID\n";
                }
                if (!campoNumerico(form.txtIdPessoa.value)){
                    mensagem = mensagem + "O campo ID deve ser numérico\n";
                }
                if (!campoNumerico(form.txtNumero.value)){
                    mensagem = mensagem + "O campo Número deve ser numérico\n";
                }
                if (form.txtNome.value == ""){
                    mensagem = mensagem + "Informe o Nome\n";
                }
                if (form.txtCpf.value == ""){
                    mensagem = mensagem + "Informe o CPF\n";
                }
                if (form.txtLogradouro.value == ""){
                    mensagem = mensagem + "Informe o Logradouro\n";
                }
                if (form.txtCep.value == ""){
                    mensagem = mensagem + "Informe o CEP\n";
                }
                if (form.txtBairro.value == ""){
                    mensagem = mensagem + "Informe o Bairro\n";
                }
                if (form.txtUf.value == ""){
                    mensagem = mensagem + "Informe o UF\n";
                }
                if (form.txtNumero.value == ""){
                    mensagem = mensagem + "Informe o Número\n";
                }
                if (form.txtTelefone.value == ""){
                    mensagem = mensagem + "Informe o Telefone\n";
                }
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            
        </SCRIPT>
        </div>

    </body>
</html>