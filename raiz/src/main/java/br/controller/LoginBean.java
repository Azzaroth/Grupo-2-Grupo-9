/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import static antlr.Tool.version;
import br.model.Cliente;
import br.model.Pedido;
import br.model.Produto;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author azaroth
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean {

    private String email;
    private String senha;
    private String nome;
    private Produto pRam = new Produto();
    private Produto pHd = new Produto();
    private Produto pMae = new Produto();
    private Produto pFonte = new Produto();
    private Produto pProcessador = new Produto();
    private int numParcelas;

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public Produto getpRam() {
        return pRam;
    }

    public void setpRam(Produto pRam) {
        this.pRam = pRam;
    }

    public Produto getpHd() {
        return pHd;
    }

    public void setpHd(Produto pHd) {
        this.pHd = pHd;
    }

    public Produto getpMae() {
        return pMae;
    }

    public void setpMae(Produto pMae) {
        this.pMae = pMae;
    }

    public Produto getpFonte() {
        return pFonte;
    }

    public void setpFonte(Produto pFonte) {
        this.pFonte = pFonte;
    }

    public Produto getpProcessador() {
        return pProcessador;
    }

    public void setpProcessador(Produto pProcessador) {
        this.pProcessador = pProcessador;
    }

    public Produto getpVideo() {
        return pVideo;
    }

    public void setpVideo(Produto pVideo) {
        this.pVideo = pVideo;
    }

    public Produto getpGabinete() {
        return pGabinete;
    }

    public void setpGabinete(Produto pGabinete) {
        this.pGabinete = pGabinete;
    }
    private Produto pVideo = new Produto();
    private Produto pGabinete = new Produto();

    private boolean autenticado;
    private ExternalContext context;

    private long id_cliente;
    private Pedido p = new Pedido();

    public void autenticar(ActionEvent actionEvent) throws IOException {
        Cliente c = new ClienteDAO().validar(this.getEmail(), this.getSenha());
        email="";
        if (c == null) {
            this.setAutenticado(false);
            setContext(FacesContext.getCurrentInstance().getExternalContext());
            getContext().redirect(getContext().getRequestContextPath() + "/faces/erro.xhtml");
        } else {
            this.nome = c.getNome();
            this.p.setCliente_id(c.getId());
            this.setAutenticado(true);
            setContext(FacesContext.getCurrentInstance().getExternalContext());
            getContext().redirect(getContext().getRequestContextPath() + "/faces/sucesso.xhtml");
        }
    }

    public boolean verificaCompra() {
        if (p.getRam() == null
                || p.getHd() == null
                || p.getMae() == null
                || p.getFonte() == null
                || p.getProcessador() == null
                || p.getVideo() == null
                || p.getGabinete() == null) {
            return false;
        }
        return true;
    }

    public String addProduto(Produto p) throws IOException {
        if (p.getCategoria().equals("ram")) {
            this.p.setRam(p.getId());
            this.pRam = p;
        } else if (p.getCategoria().equals("hd")) {
            this.p.setHd(p.getId());
            this.pHd = p;
        } else if (p.getCategoria().equals("mae")) {
            this.p.setMae(p.getId());
            this.pMae = p;
        } else if (p.getCategoria().equals("fonte")) {
            this.p.setFonte(p.getId());
            this.pFonte = p;
        } else if (p.getCategoria().equals("gabinete")) {
            this.p.setGabinete(p.getId());
            this.pGabinete = p;
        } else if (p.getCategoria().equals("processador")) {
            this.p.setProcessador(p.getId());
            this.pProcessador = p;
        } else if (p.getCategoria().equals("video")) {
            this.p.setVideo(p.getId());
            this.pVideo = p;
        }
        setContext(FacesContext.getCurrentInstance().getExternalContext());
        getContext().redirect(getContext().getRequestContextPath() + "/faces/Produtos.xhtml");
        return "start";
    }

    public void limpar() throws IOException {
        this.p = new Pedido();
        this.pRam = new Produto();
        this.pHd = new Produto();
        this.pMae = new Produto();
        this.pFonte = new Produto();
        this.pProcessador = new Produto();
        this.pVideo = new Produto();
        this.pGabinete = new Produto();
        setContext(FacesContext.getCurrentInstance().getExternalContext());
        getContext().redirect(getContext().getRequestContextPath() + "/faces/Produtos.xhtml");
    }

    public void finalizarCompra(String forma) throws IOException {
        this.p.setForma(forma);
        if(forma.equals("boleto"))
            this.p.setTotal(this.getDescontoBoleto());
        else
            if(numParcelas == 0)
                this.p.setTotal(this.getDescontoCartao());
        else
            this.p.setTotal(this.getSubtotal());
        new PedidoDAO().inserir(p);
        this.limpar();
        setContext(FacesContext.getCurrentInstance().getExternalContext());
        getContext().redirect(getContext().getRequestContextPath() + "/faces/sucesso.xhtml");
    }

    public double getSubtotal() {
        double sub = 0;
        sub += pRam.getPreco();
        sub += pHd.getPreco();
        sub += pMae.getPreco();
        sub += pFonte.getPreco();
        sub += pProcessador.getPreco();
        sub += pVideo.getPreco();
        sub += pGabinete.getPreco();
        return sub;
    }
    
    public double getDescontoBoleto() {
        return this.getSubtotal() * 0.9;
    }

    public double getDescontoCartao() {
        return this.getSubtotal() * 0.95;
    }

    public void deslogar(ActionEvent actionEvent) throws IOException {
        this.setAutenticado(false);
        setContext(FacesContext.getCurrentInstance().getExternalContext());
        getContext().redirect(getContext().getRequestContextPath() + "/faces/Produtos.xhtml");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAutenticado() {
        return autenticado;
    }

    public void setAutenticado(boolean autenticado) {
        this.autenticado = autenticado;
    }

    public ExternalContext getContext() {
        return context;
    }

    public void setContext(ExternalContext context) {
        this.context = context;
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Pedido getP() {
        return p;
    }

    public void setP(Pedido p) {
        this.p = p;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
