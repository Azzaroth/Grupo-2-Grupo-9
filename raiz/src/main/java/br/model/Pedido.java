/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author azaroth
 */
@Entity
public class Pedido implements Serializable {
    
    @GeneratedValue
    @Id
    private long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;
    
}
