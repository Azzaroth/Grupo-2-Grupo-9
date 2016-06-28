/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 *
 * @author azaroth
 */
@Entity
public class Pedido implements Serializable {
    
    @GeneratedValue
    @Id
    private long id;
    @Column(name="CLIENTE_ID")
    @NotNull
    private long cliente_id;
    @Column(name="RAM")
    @NotNull
    private Long ram;
    @Column(name="HD")
    @NotNull
    private Long hd;
    @Column(name="FONTE")
    @NotNull
    private Long fonte;
    @Column(name="MAE")
    @NotNull
    private Long mae;
    @Column(name="GABINETE")
    @NotNull
    private Long gabinete;
    @Column(name="PROCESSADOR")
    @NotNull
    private Long processador;
    @Column(name="VIDEO")
    @NotNull
    private Long video;
    @Column(name="FORMA")
    @NotNull
    private String forma;
    @Column(name="TOTAL", length = 30)
    @NotNull
    private double total;
    
    
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getRam() {
        return ram;
    }

    public void setRam(Long ram) {
        this.ram = ram;
    }

    public Long getHd() {
        return hd;
    }

    public void setHd(Long hd) {
        this.hd = hd;
    }

    public Long getFonte() {
        return fonte;
    }

    public void setFonte(Long fonte) {
        this.fonte = fonte;
    }

    public Long getMae() {
        return mae;
    }

    public void setMae(Long mae) {
        this.mae = mae;
    }

    public Long getGabinete() {
        return gabinete;
    }

    public void setGabinete(Long gabinete) {
        this.gabinete = gabinete;
    }

    public Long getProcessador() {
        return processador;
    }

    public void setProcessador(Long processador) {
        this.processador = processador;
    }

    public Long getVideo() {
        return video;
    }

    public void setVideo(Long video) {
        this.video = video;
    }

    public long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(long cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
}
