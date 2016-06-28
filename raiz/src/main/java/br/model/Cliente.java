/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.model;

import br.model.Pedido;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author azaroth
 */
@Entity
@Table(name = "CLIENTES")
public class Cliente implements Serializable {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "CLIENTE_ID")
    private long id;
    @Column(name = "NOME", length = 60)
    @NotNull
    private String nome;
    @Column(name = "IDADE", length = 3)
    @NotNull
    private int idade;
    @Column(name = "CPF", length = 14)
    @NotNull
    private String cpf;
    @Column(name = "SENHA", length = 22)
    @NotNull
    private String senha;
    @Column(name = "EMAIL")
    @NotNull
    private String email;
    @Column(name = "RUA", length = 40)
    @NotNull
    private String rua;
    @Column(name = "NUMERO", length = 10)
    @NotNull
    private int numero;
    
    /*@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Pedido> pedidos;*/

    public Cliente() {
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    /*public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }*/

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
  
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
       
}
