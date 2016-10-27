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
import model.Automovel;
import model.Avaliacao;
import model.Integrante;

/**
 *
 * @author lukin
 */
public class ManterAvaliacaoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } /* else if (acao.equals("confirmarEditar")) {
         confirmarEditar(request, response);
         } else if (acao.equals("prepararExcluir")) {
         prepararExcluir(request, response);
         } else if (acao.equals("confirmarExcluir")) {
         confirmarExcluir(request, response);
         }
         */

    }

    public void prepararIncluir(HttpServletRequest request,
            HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("avaliacoes", Automovel.obterAutomoveis());
            RequestDispatcher view = request.getRequestDispatcher("/manterAvaliacao.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int idAvaliacao = Integer.parseInt(request.getParameter("txtIdAvaliacao"));
        int frequencia = Integer.parseInt(request.getParameter("txtFrequencia"));
        String comparecimento = request.getParameter("txtComparecimento");
        String data = request.getParameter("txtData");
        int FK_integrante = Integer.parseInt(request.getParameter("FK_integrante"));

        try {
            /*Automovel automovel = null;
             if (coordenador != 0) {
             automovel = Professor.obterProfessor(coordenador);
             }*/
            Avaliacao avaliacao = new Avaliacao(idAvaliacao, frequencia, comparecimento, data, FK_integrante);
            avaliacao.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAutomovelController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public void prepararEditar(HttpServletRequest request,
            HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("integrantes", Integrante.obterIntegrantes());
            int idAvaliacao = Integer.parseInt(request.getParameter("idAvaliacao"));
            Avaliacao arquitetura = Avaliacao.obterAvaliacao(idAvaliacao);
            request.setAttribute("arquitetura", arquitetura);
            RequestDispatcher view = request.getRequestDispatcher("/manterAvaliacao.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ManterAvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterAvaliacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}