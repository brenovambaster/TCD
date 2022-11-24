/*
 * Copyright (C) 2022 Pedro Dias
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package com.mycompany.adotapet.endereco;

import com.mycompany.adotapet.entidade.Entidade;
import com.mycompany.adotapet.tipoLogradouro.TipoLogradouro;

/**
 * Classe Endereco
 * @author Pedro Dias
 */
public class Endereco extends Entidade{
    private TipoLogradouro tipoLogradouro;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private Character[] estado;
    private Integer cep;
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    
    public Endereco() {
        estado = new Character[2];
    }

    public Endereco(TipoLogradouro tipoLogradouro, String logadouro, Integer numero, String complemento, String bairro, String cidade, Character[] estado, Integer cep) {
        this();
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logadouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogadouro() {
        return logradouro;
    }

    public void setLogadouro(String logadouro) {
        this.logradouro = logadouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Character[] getEstado() {
        return estado;
    }

    public void setEstado(Character[] estado) {
        this.estado = estado;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }
    
    //</editor-fold>

    @Override
    public String toString() {
        return "Endereco{" 
                + ", " + tipoLogradouro 
                + ", logadouro = " + logradouro 
                + ", numero = " + numero 
                + ", complemento = " + complemento 
                + ", bairro = " + bairro 
                + ", cidade = " + cidade 
                + ", estado = " + estado[0] +estado[1]
                + ", cep = " + cep 
                + ", " + super.toString()
                + '}';
    }
}
