package model_old;

import dao.PecaDAO;
import java.sql.SQLException;
import java.util.List;

public class Peca {

    private int idPeca, quantidade;
    private String nome, modelo;
    private float precoCompra;
    private final int idTipoPeca;
    private TipoPeca tipopeca;

    public Peca(int idPeca, int quantidade, String nome, String modelo, float precoCompra, int idTipoPeca) {
        this.idPeca = idPeca;
        this.quantidade = quantidade;
        this.nome = nome;
        this.modelo = modelo;
        this.precoCompra = precoCompra;
        this.idTipoPeca = idTipoPeca;
    }

    public TipoPeca getTipopeca() throws ClassNotFoundException {
        if ((tipopeca == null) && (idTipoPeca != 0)) {
            tipopeca = TipoPeca.obterTipoPeca(idTipoPeca);
        }
        return tipopeca;
    }

    public void setTipopeca(TipoPeca tipopeca) {
        this.tipopeca = tipopeca;
    }

    public int getIdTipoPeca() {
        return idTipoPeca;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(float precoCompra) {
        this.precoCompra = precoCompra;
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        PecaDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        PecaDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        PecaDAO.excluir(this);
    }

    public static List<Peca> obterPecas() throws ClassNotFoundException, SQLException {
        return PecaDAO.obterPecas();
    }
    
    public static List<Float> obterPrecos() throws ClassNotFoundException, SQLException {
        return PecaDAO.obterPrecos();
    }

    public static Peca obterPeca(int idPeca) throws ClassNotFoundException {
        return PecaDAO.obterPeca(idPeca);
    }

}