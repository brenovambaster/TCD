/*
 * Copyright (C) 2022 Breno Vambaster C. L
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
package com.mycompany.adotapet.telefone;

import com.mycompany.adotapet.entidade.Entidade;

/**
 * Classe Telefone
 *
 * @author Breno Vambaster C. L
 */
public class Telefone extends Entidade {

    private Short ddd;
    private Integer numero;
    private Boolean mensagem;

    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Telefone() {
    }

    public Telefone(Short ddd, Integer numero, Boolean mensagem) {
        this.ddd = ddd;
        this.numero = numero;
        this.mensagem = mensagem;
    }

    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Short getDDD() {
        return ddd;
    }

    public void setDDD(Short DDD) {
        this.ddd = DDD;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Boolean getMensagem() {
        return mensagem;
    }

    public void setMensagem(Boolean mensagem) {
        this.mensagem = mensagem;
    }
    
    //</editor-fold>
    
    public static void validarTelefone(Telefone telefone) throws Exception {
        Telefone telefone2 = new TelefoneDAO().findByNumber(telefone.getNumero());
        if (telefone2 != null) {
            throw new Exception("Telefone ja cadastrado!");
        }
    }
    
    @Override
    public String toString() {
        return "Telefone{" 
                + "ddd = " + ddd 
                + ", numero=" + numero 
                + ", mensagem=" + mensagem 
                + ", " + super.toString() 
                + "}";
    }

}
