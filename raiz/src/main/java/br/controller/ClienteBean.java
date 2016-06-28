/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.controller;

import br.model.Cliente;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author azaroth
 */
@ManagedBean(name = "cliente")
@SessionScoped
public class ClienteBean implements Serializable {

    private Cliente c = new Cliente();
    

    List clientes = new ArrayList();

    
    public ClienteBean() {
        clientes = new ClienteDAO().listar();
        c = new Cliente();
    }

    public void cadastrar(ActionEvent actionEvent) throws IOException {
        new ClienteDAO().inserir(c);
        clientes = new ClienteDAO().listar();
        c = new Cliente();
        setContext(FacesContext.getCurrentInstance().getExternalContext());
        getContext().redirect(getContext().getRequestContextPath() + "/faces/sucesso.xhtml");
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public List getClientes() {
        return clientes;
    }

    public void setClientes(List clientes) {
        this.clientes = clientes;
    }
    
    public List<Cliente> listarCliente(){
        List<Cliente> listaClientes = new ClienteDAO().listar();
        return listaClientes;
    }
    
    private ExternalContext context;

    public ExternalContext getContext() {
        return context;
    }

    public void setContext(ExternalContext context) {
        this.context = context;
    }

}
