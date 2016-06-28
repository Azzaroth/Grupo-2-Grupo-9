package br.controller;

import br.model.Produto;
import java.io.IOException;
import java.io.Serializable;
import static java.security.AccessController.getContext;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author azaroth
 */
@ManagedBean(name = "produto")
@SessionScoped
public class ProdutoBean implements Serializable {
    
    private Produto selectedProduto;

    public Produto getSelectedProduto() {
        return selectedProduto;
    }

    public void setSelectedProduto(Produto selectedProduto) {
        this.selectedProduto = selectedProduto;
    }
    
    private String categoria = "ram";
    
    private ExternalContext context;
    
    private Produto p = new Produto();

    private List produtos = new ArrayList();

    public ProdutoBean() {
        produtos = new ProdutoDAO().listar();
        p = new Produto();
    }

    public void cadastrar(ActionEvent actionEvent) {
        new ProdutoDAO().inserir(getP());
        setProdutos(new ProdutoDAO().listar());
        setP(new Produto());
    }

    public Produto getP() {
        return p;
    }

    public void setP(Produto p) {
        this.p = p;
    }

    public List getProdutos() {
        return produtos;
    }

    public void setProdutos(List produto) {
        this.produtos = produtos;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) throws IOException {
        this.categoria = categoria;
        setContext(FacesContext.getCurrentInstance().getExternalContext());
        getContext().redirect(getContext().getRequestContextPath() + "/faces/Produtos.xhtml");
    }
    
    public List<Produto> listarProduto(){
        List<Produto> listaProdutos = new ProdutoDAO().listar();
        return listaProdutos;
    }
    
    public List<Produto> listarProdutoEspecifico(){
        List<Produto> listProdutos;
        if (getCategoria().equals(" ")) return listarProduto();
        else {
        listProdutos = new ProdutoDAO().listarEspecifico(getCategoria());
        }
        return listProdutos;
    }

    public ExternalContext getContext() {
        return context;
    }

    public void setContext(ExternalContext context) {
        this.context = context;
    }

    
    
}
