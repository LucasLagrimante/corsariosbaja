/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Peca;
import model.TipoPeca;

/**
 *
 * @author Aluno
 */
public class ManterPecaController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }

    }

    public void prepararIncluir(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("tipopecas", TipoPeca.obterTiposPeca());
            RequestDispatcher view = request.getRequestDispatcher("/manterPeca.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int idPeca = Integer.parseInt(request.getParameter("txtIdPeca"));
        int quantidade = Integer.parseInt(request.getParameter("txtQuantidade"));
        String nome = request.getParameter("txtNome");
        String modelo = request.getParameter("txtModelo");
        int precoCompra = Integer.parseInt(request.getParameter("txtPrecoCompra"));
        int idTipoPeca = Integer.parseInt(request.getParameter("selectTipoPeca"));

        try {
            TipoPeca tipopeca = null;
            if (idTipoPeca != 0) {
                tipopeca = TipoPeca.obterTipoPeca(idTipoPeca);
            }
            Peca peca = new Peca(idPeca, quantidade, nome, modelo, precoCompra, idTipoPeca);
            peca.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPecaController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("tipopecas", TipoPeca.obterTiposPeca());
            int idPeca = Integer.parseInt(request.getParameter("txtIdPeca"));
            Peca peca = Peca.obterPeca(idPeca);
            request.setAttribute("peca", peca);
            RequestDispatcher view = request.getRequestDispatcher("/manterPeca.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
        int idPeca = Integer.parseInt(request.getParameter("txtIdPeca"));
        int quantidade = Integer.parseInt(request.getParameter("txtQuantidade"));
        String nome = request.getParameter("txtNome");
        String modelo = request.getParameter("txtModelo");
        int precoCompra = Integer.parseInt(request.getParameter("txtPrecoCompra"));
        int idTipoPeca = Integer.parseInt(request.getParameter("selectTipoPeca"));

        try {
            TipoPeca tipopeca = null;
            if (idTipoPeca != 0) {
                tipopeca = TipoPeca.obterTipoPeca(idTipoPeca);
            }
            Peca peca = new Peca(idPeca, quantidade, nome, modelo, precoCompra, idTipoPeca);
            peca.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPecaController");
            view.forward(request, response);
        } catch (ServletException ex) {
            throw ex;
        } catch (IOException ex) {
            throw ex;
        } catch (ClassNotFoundException ex) {
            throw ex;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("tipopecas", TipoPeca.obterTiposPeca());
            int idPeca = Integer.parseInt(request.getParameter("txtIdPeca"));
            Peca peca = Peca.obterPeca(idPeca);
            request.setAttribute("peca", peca);
            RequestDispatcher view = request.getRequestDispatcher("/manterPeca.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int idPeca = Integer.parseInt(request.getParameter("txtIdPeca"));
        int quantidade = Integer.parseInt(request.getParameter("txtQuantidade"));
        String nome = request.getParameter("txtNome");
        String modelo = request.getParameter("txtModelo");
        int precoCompra = Integer.parseInt(request.getParameter("txtPrecoCompra"));
        int idTipoPeca = Integer.parseInt(request.getParameter("selectTipoPeca"));

        try {
            TipoPeca tipopeca = null;
            if (idTipoPeca != 0) {
                tipopeca = TipoPeca.obterTipoPeca(idTipoPeca);
            }
            Peca peca = new Peca(idPeca, quantidade, nome, modelo, precoCompra, idTipoPeca);
            peca.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPecaController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterIntegranteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPecaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterIntegranteController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterPecaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}