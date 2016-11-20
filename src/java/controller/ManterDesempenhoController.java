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
import model.Desempenho;
import model.Integrante;
import model.Pessoa;
import model.TipoPista;

/**
 *
 * @author Lucas
 */
public class ManterDesempenhoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
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
            request.setAttribute("automoveis", Automovel.obterAutomoveis());
            request.setAttribute("tipospista", TipoPista.obterTiposPista());
            request.setAttribute("integrantes", Integrante.obterIntegrantes());
            RequestDispatcher view = request.getRequestDispatcher("/manterDesempenho.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int idDesempenho = Integer.parseInt(request.getParameter("txtIdDesempenho"));
        String nome = request.getParameter("txtNome");
        String data = request.getParameter("txtData");
        String hora = request.getParameter("txtHora");
        float velocidadeMedia = Float.parseFloat(request.getParameter("txtVelocidadeMedia"));
        float aceleracaoMedia = Float.parseFloat(request.getParameter("txtAceleracaoMedia"));
        String tempoPista = request.getParameter("txtTempoPista");
        float frenagem = Float.parseFloat(request.getParameter("txtFrenagem"));
        int idAutomovel = Integer.parseInt(request.getParameter("selectAutomovel"));
        int idTipoPista = Integer.parseInt(request.getParameter("selectTipoPista"));
        int matricula = Integer.parseInt(request.getParameter("selectIntegrante"));
        try {
            Automovel automovel = null;
            if (idAutomovel != 0) {
                automovel = Automovel.obterAutomovel(idAutomovel);
            }
            TipoPista tipopista = null;
            if (idTipoPista != 0) {
                tipopista = TipoPista.obterTipoPista(idTipoPista);
            }
            Integrante integrante = null;
            if (matricula != 0) {
                integrante = Integrante.obterIntegrante(matricula);
            }
            Desempenho desempenho = new Desempenho(idDesempenho, nome, data, hora, velocidadeMedia, aceleracaoMedia, tempoPista, frenagem, idAutomovel, idTipoPista, matricula);
            desempenho.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaDesempenhoController");
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
            request.setAttribute("automoveis", Automovel.obterAutomoveis());
            request.setAttribute("tipospista", TipoPista.obterTiposPista());
            request.setAttribute("integrantes", Integrante.obterIntegrantes());
            int idDesempenho = Integer.parseInt(request.getParameter("idDesempenho"));
            Desempenho desempenho = Desempenho.obterDesempenho(idDesempenho);
            request.setAttribute("desempenho", desempenho);
            RequestDispatcher view = request.getRequestDispatcher("/manterDesempenho.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {

        } catch (IOException ex) {

        } catch (ClassNotFoundException ex) {

        }
    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int idDesempenho = Integer.parseInt(request.getParameter("txtIdDesempenho"));
        String nome = request.getParameter("txtNome");
        String data = request.getParameter("txtData");
        String hora = request.getParameter("txtHora");
        float velocidadeMedia = Float.parseFloat(request.getParameter("txtVelocidadeMedia"));
        float aceleracaoMedia = Float.parseFloat(request.getParameter("txtAceleracaoMedia"));
        String tempoPista = request.getParameter("txtTempoPista");
        float frenagem = Float.parseFloat(request.getParameter("txtFrenagem"));
        int idAutomovel = Integer.parseInt(request.getParameter("selectAutomovel"));
        int idTipoPista = Integer.parseInt(request.getParameter("selectTipoPista"));
        int matricula = Integer.parseInt(request.getParameter("selectIntegrante"));
        try {
            Automovel automovel = null;
            if (idAutomovel != 0) {
                automovel = Automovel.obterAutomovel(idAutomovel);
            }
            TipoPista tipopista = null;
            if (idTipoPista != 0) {
                tipopista = TipoPista.obterTipoPista(idTipoPista);
            }
            Integrante integrante = null;
            if (matricula != 0) {
                integrante = Integrante.obterIntegrante(matricula);
            }
            Desempenho desempenho = new Desempenho(idDesempenho, nome, data, hora, velocidadeMedia, aceleracaoMedia, tempoPista, frenagem, idAutomovel, idTipoPista, matricula);
            desempenho.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaDesempenhoController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("automoveis", Automovel.obterAutomoveis());
            request.setAttribute("tipospista", TipoPista.obterTiposPista());
            request.setAttribute("integrantes", Integrante.obterIntegrantes());
            int idDesempenho = Integer.parseInt(request.getParameter("idDesempenho"));
            Desempenho desempenho = Desempenho.obterDesempenho(idDesempenho);
            request.setAttribute("desempenho", desempenho);
            RequestDispatcher view = request.getRequestDispatcher("/manterDesempenho.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int idDesempenho = Integer.parseInt(request.getParameter("txtIdDesempenho"));
        String nome = request.getParameter("txtNome");
        String data = request.getParameter("txtData");
        String hora = request.getParameter("txtHora");
        float velocidadeMedia = Float.parseFloat(request.getParameter("txtVelocidadeMedia"));
        float aceleracaoMedia = Float.parseFloat(request.getParameter("txtAceleracaoMedia"));
        String tempoPista = request.getParameter("txtTempoPista");
        float frenagem = Float.parseFloat(request.getParameter("txtFrenagem"));
        int idAutomovel = Integer.parseInt(request.getParameter("selectAutomovel"));
        int idTipoPista = Integer.parseInt(request.getParameter("selectTipoPista"));
        int matricula = Integer.parseInt(request.getParameter("selectIntegrante"));
        try {
            Automovel automovel = null;
            if (idAutomovel != 0) {
                automovel = Automovel.obterAutomovel(idAutomovel);
            }
            TipoPista tipopista = null;
            if (idTipoPista != 0) {
                tipopista = TipoPista.obterTipoPista(idTipoPista);
            }
            Integrante integrante = null;
            if (matricula != 0) {
                integrante = Integrante.obterIntegrante(matricula);
            }
            Desempenho desempenho = new Desempenho(idDesempenho, nome, data, hora, velocidadeMedia, aceleracaoMedia, tempoPista, frenagem, idAutomovel, idTipoPista, matricula);
            desempenho.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaDesempenhoController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
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
            Logger.getLogger(ManterDesempenhoController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ManterDesempenhoController.class.getName()).log(Level.SEVERE, null, ex);
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