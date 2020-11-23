/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bd;

/**
 *
 * @author sakurah
 */
public class Maquina {
    
    private Integer id;
    private String hostname;
    private Integer usuario_id;

    @Override
    public String toString() {
        return "Maquina{" + "id=" + id + ", hostname=" + hostname + ", usuario_id=" + usuario_id + '}';
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }
    
    
    
}
