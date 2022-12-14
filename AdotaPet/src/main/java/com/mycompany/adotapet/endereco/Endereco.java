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
 * 
 * <pre>CREATE TABLE `endereco` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `idTipologradouro` bigint(20) unsigned NOT NULL,
  `logradouro` varchar(35) NOT NULL,
  `numero` int(11) NOT NULL,
  `complemento` varchar(35) NOT NULL,
  `bairro` varchar(35) NOT NULL,
  `cidade` varchar(35) NOT NULL,
  `estado` varchar(2) NOT NULL,
  `cep` int(11) NOT NULL,
  `excluido` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `idTipologradouro` (`idTipologradouro`),
  CONSTRAINT `endereco_ibfk_1` FOREIGN KEY (`idTipologradouro`) REFERENCES `tipologradouro` (`id`)
) ENGINE=InnoDB DEFAULT</pre>
 * Classe Endereco
 *
 * @author Pedro Dias
 */
public class Endereco extends Entidade {
    
    private TipoLogradouro tipoLogradouro;
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Integer cep;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Endereco() {
        
    }
    
    public Endereco(TipoLogradouro tipoLogradouro, String logradouro, Integer numero, String complemento, String bairro, String cidade, String estado, Integer cep) throws Exception {
        this.tipoLogradouro = tipoLogradouro;
        setLogadouro(logradouro);
        this.numero = numero;
        setComplemento(complemento);
        setBairro(bairro);
        setCidade(cidade);
        setEstado(estado);
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
    
    public final void setLogadouro(String logradouro) throws Exception {
        if (logradouro == null || logradouro.trim().length() >= 35 || logradouro.trim().length() == 0) {
            throw new IllegalArgumentException("Nome do logradouro n??o pode exceder 35 caracteres");
        } else {
            this.logradouro = logradouro.trim();
        }
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
    
    public final void setComplemento(String complemento) throws Exception {
        if (complemento == null || complemento.trim().length() >= 35 || complemento.trim().length() == 0) {
            throw new IllegalArgumentException("Nome do complemento n??o pode exceder 35 caracteres");
        } else {
            this.complemento = complemento.trim();
        }
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public final void setBairro(String bairro) throws Exception {
        if (bairro == null || bairro.trim().length() >= 35 || bairro.trim().length() == 0) {
            throw new IllegalArgumentException("Nome do bairro n??o pode exceder 35 caracteres");
        } else {
            this.bairro = bairro.trim();
        }
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public final void setCidade(String cidade) throws Exception {
        if (cidade == null || cidade.trim().length() >= 35 || cidade.trim().length() == 0) {
            throw new IllegalArgumentException("Nome da cidade n??o pode exceder 35 caracteres");
        } else {
            this.cidade = cidade.trim();
        }
    }
    
    public String getEstado() {
        return estado;
    }
    
    public final void setEstado(String estado) throws Exception {
        if (estado == null || estado.trim().length() > 2 || estado.trim().length() == 0) {
            throw new IllegalArgumentException("Estado deve conter apenas 2 caracteres");    
        } else{
            this.estado = estado.trim();
        }
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
                + ", estado = " + estado
                + ", cep = " + cep
                + ", " + super.toString()
                + '}';
    }
}
